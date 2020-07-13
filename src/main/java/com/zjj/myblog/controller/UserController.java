package com.zjj.myblog.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Assert;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjj.myblog.entity.User;
import com.zjj.myblog.mapper.UserMapper;
import com.zjj.myblog.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserMapper userMapper;

    @RequestMapping("/login")
    public String loginHtml() {
        return "user/login";
    }

    @RequestMapping("/register")
    public String registerHTML() {
        return "user/reg";
    }

    @RequestMapping("/technology")
    public String technology() {
        return "catalog";
    }

    @RequestMapping("/index")
    public String index(HttpSession session) {
        session.setAttribute("user", "123");
        return "index";
    }

    @RequestMapping("/add")
    public String add() {
        return "option/add";
    }


}
