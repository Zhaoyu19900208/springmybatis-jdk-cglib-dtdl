package com.cn.cglib;

/**
 * @author zy
 * 2022/11/11  15:15
 */
public class Tools {

    public static String replaceBy(String value ,String Symbol0 ,String Symbol1){
        return value=value.replace(Symbol0, Symbol1);
    }

    public static int indexOfBy(String value ,String Symbol0){
        int a=value.indexOf(Symbol0);
        return a;
    }

}
