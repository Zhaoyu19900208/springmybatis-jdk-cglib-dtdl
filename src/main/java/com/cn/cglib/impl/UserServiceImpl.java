package com.cn.cglib.impl;

import com.cn.cglib.UserService;

/**
 * @author zy
 * 2022/11/19  21:46
 */
public class UserServiceImpl implements UserService {

    @Override
    public void say() {
        System.out.println("say 我是cglib代理类");
    }

    @Override
    public void say2() {
        System.out.println("say2 我是cglib代理类");
    }

    public final void finalMethod() {
        System.out.println("finalMethod 我是cglib代理类");
    }

    public static void staticMethod() {
        System.out.println("staticMethod 我是cglib代理类");
    }

}

