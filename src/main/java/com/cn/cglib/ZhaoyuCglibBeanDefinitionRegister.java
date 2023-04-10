package com.cn.cglib;

import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import net.sf.cglib.proxy.Enhancer;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author zy
 * 增加自定义的bean
 * 2022/11/15  23:27
 */
public class ZhaoyuCglibBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    private List<Class<?>> classList ;
    @Override
    @SneakyThrows
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(ZhaoyuCglibScan.class.getName());
        Object value = annotationAttributes.get("value");
        final String path = value.toString().replace(".", "/");
        ClassLoader classLoader = ZhaoyuCglibBeanDefinitionRegister.class.getClassLoader();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(Enhancer.class);
        registry.registerBeanDefinition("enhancer",beanDefinition);
        //绝对路径
        URL resource = classLoader.getResource(path);
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            classList = new LinkedList<>();
            for (File item : files) {
                String path1 = Tools.replaceBy(path, "/", "\\");
                int start = Tools.indexOfBy(item.getAbsolutePath(), path1);
                int end = Tools.indexOfBy(item.getAbsolutePath(), ".class");
                String aClass = item.getAbsolutePath().substring(start, end);
                String replaceBy = Tools.replaceBy(aClass, "\\", ".");
                Class<?> classSome = classLoader.loadClass(replaceBy);
                classList.add(classSome);
            }
        }
        for (Class aClass : classList) {
            AbstractBeanDefinition beanDefinitionOther = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
            //代理对象
            beanDefinitionOther.setBeanClass(ZhaoyuFactoryBean.class);
            //代理对象的构造器 传 被代理对象
            beanDefinitionOther.getConstructorArgumentValues().addGenericArgumentValue(aClass);
            //spring 注册 bean 名称：被代理对象的名称 值：代理对象
            registry.registerBeanDefinition(StrUtil.lowerFirst(aClass.getSimpleName()),beanDefinitionOther);
        }
    }
}
