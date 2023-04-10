package com.cn.cglib;

import org.springframework.context.annotation.Import;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author zy
 * 2022/11/15  23:14
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ZhaoyuCglibBeanDefinitionRegister.class)
public @interface ZhaoyuCglibScan {

    String value() default "";
}
