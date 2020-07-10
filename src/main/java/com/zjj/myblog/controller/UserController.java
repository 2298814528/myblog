package com.zjj.myblog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2020-07-11
 */
@Controller
public class UserController {
    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }
    @RequestMapping("/technology")
    public String technology(){
        return "catalog";
    }
    @RequestMapping("/index")
    public String index(){
        return "option/index";
    }

}
