package com.zjj.myblog.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Assert;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjj.myblog.entity.User;
import com.zjj.myblog.mapper.UserMapper;
import com.zjj.myblog.service.UserService;
import com.zjj.myblog.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2020-07-12
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String loginHtml() {
        return "user/login";
    }
    /**
     * 注册
     * @return
     */
    @RequestMapping("/register")
    public String registerHTML() {
        return "user/reg";
    }

    /**
     * 所用技术
     * @return
     */
    @RequestMapping("/technology")
    public String technology() {
        return "catalog";
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpSession session) {
        return "index";
    }

    @RequestMapping("/add")
    public String add() {
        return "option/add";
    }

    @RequestMapping("/home")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        session.setAttribute("point",user.getPoint());
        return "user/home";
    }

    @RequestMapping("/set")
    public String set(HttpServletRequest request) {
        return "user/set";
    }

    @RequestMapping("/message")
    public String message() {
        return "user/message";
    }

    @RequestMapping("/active")
    public String active() {
        return "user/active";
    }

    @RequestMapping("/user/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }


}
