package com.cn.cglib.impl;

/**
 * @author zy
 * 2022/12/2  10:25
 */
public class ZhaoyuMapperImpl implements ZhaoyuMapper {
    @Override
    public String selectById(String id, String name) {
        System.out.println(id+name);
        return id+name;
    }
}
