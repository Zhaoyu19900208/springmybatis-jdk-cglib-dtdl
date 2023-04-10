package com.cn.cglib;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 */

@Configuration
@ComponentScan("com.cn.cglib")
@ZhaoyuCglibScan(value = "com.cn.cglib.impl")
public class AppConfig {

}
