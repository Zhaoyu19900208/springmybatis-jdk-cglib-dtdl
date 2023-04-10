package com.cn.supplierperformancetransfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zy
 * 2023/4/7  13:27
 */
@Controller
public class SecurityController {

//    @RequestMapping(value = "/login", method = {RequestMethod.GET})
//    public String getAccessConfirmation() {
//        return "login";
//    }

    @RequestMapping("/login")
    public String view() {
        return "login";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
