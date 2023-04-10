package com.cn.cglib;

import com.cn.cglib.impl.UserServiceImpl;
import com.cn.cglib.impl.ZhaoyuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author zy
 * 2022/11/15  22:58
 */
@Component
public class ZhaoyuService {

    @Autowired
    @Qualifier(value ="zhaoyuMapperImpl")
    private ZhaoyuMapper zhaoyuMapper;

    @Autowired
    private UserServiceImpl userServiceImpl;

    public String queryAll(){
        String s ="|";
        zhaoyuMapper.selectById("111111111111111111111111111", "zhaoyu");
        userServiceImpl.say();
        userServiceImpl.say2();
        return s;
    }

}
