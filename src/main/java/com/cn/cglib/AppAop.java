package com.cn.cglib;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */

//@EnableAspectJAutoProxy
//@SpringBootApplication
public class AppAop {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        ZhaoyuService zhaoyuService = applicationContext.getBean("zhaoyuService", ZhaoyuService.class);
        String s = zhaoyuService.queryAll();
        System.out.println(s);
    }
}
