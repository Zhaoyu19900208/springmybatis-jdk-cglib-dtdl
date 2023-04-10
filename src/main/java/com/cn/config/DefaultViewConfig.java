//package com.cn.config;
//
///**
// * @author zy
// * 2023/4/7  13:33
// */
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * @Description Description
// * @Author 一一哥Sun
// * @Date Created in 2020/3/21
// */
//@Configuration
//public class DefaultViewConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        //这里的"/"是访问路径，"forward:home.html"是请求转发到的页面名称
//        registry.addViewController("/").setViewName("forward:home.html");
//        //设置优先级
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        super.addViewControllers(registry);
//    }
//
//}
