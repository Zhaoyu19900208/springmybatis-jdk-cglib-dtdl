package com.cn.cglib;

import lombok.SneakyThrows;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zy
 * 实现 FactoryBean mybatis
 * 2022/11/15  22:06
 */

public class ZhaoyuFactoryBean implements FactoryBean {

    private Class clazz;

    //jdk 代理使用
    public ZhaoyuFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    //cglib 代理使用
    @Autowired
    private Enhancer enhancer;

    @Override
    @SneakyThrows
    public Object getObject() {
        Class<?>[] interfaces = null;
        if (clazz.isInterface()) {
            interfaces = new Class<?>[]{clazz};
            //        Proxy 只能代理接口 注:使用的是jdk
            Object instance = Proxy.newProxyInstance(ZhaoyuFactoryBean.class.getClassLoader(), interfaces, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(Object.class.equals(method.getDeclaringClass())){
                        //此处用 equals 为啥要取接口 因为mybatis 是按照 getSession().getMapper(this.mapperInterFace); 来获取bean的
                        Object invoke = method.invoke(this.getClass(), args);
                        return invoke;
                    }
                    return null;
                }
            });
            return instance;
        } else {
            // 设置enhancer对象的父类
            enhancer.setSuperclass(clazz);
            // 设置enhancer的回调对象
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    // 调用代理类 FastClass 对象
                    Object result = methodProxy.invokeSuper(o, objects);
                    return result;
                }
            });
            // 创建代理对象
            Object o = enhancer.create();
            return o;
        }
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}
