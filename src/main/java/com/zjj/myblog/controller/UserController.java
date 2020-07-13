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
    @Autowired
    FileUpload fileUpload;

    @RequestMapping("/login")
    public String loginHtml() {
        return "user/login";
    }

    @RequestMapping("/loginUser")
    public String login(String username, String password, Model model, HttpSession session) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        QueryWrapper<User> eq = userQueryWrapper.eq("username", username).eq("password", password);
        User user = userMapper.selectOne(eq);
        if (user == null) {
            model.addAttribute("error", "账号或密码错误");
            return "user/login";
        } else {
            session.setAttribute("user", username);
            return "index";
        }
    }

    @RequestMapping("/register")
    public String registerHTML() {
        return "user/reg";
    }

    @RequestMapping("/registerUser")
    public String register(User user, Model model, @RequestParam("date") String date, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //设置生日
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate time = LocalDate.parse(date, dateTimeFormatter);
        user.setBirthday(time);
        System.out.println(user);
        String path = request.getServletContext().getRealPath("/upload/");
        try {
            String filePath = fileUpload.upload(file, path);
            user.setAvatar(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDateTime now = LocalDateTime.now();
        user.setCreated(Timestamp.valueOf(now)); // 2008-9-4 20:02:10)
        user.setModified(Timestamp.valueOf(now));
        int insert = userMapper.insert(user);
        if (insert > 0) {
            return "user/login";
        } else {
            model.addAttribute("error","注册失败");
            return "user/reg";
        }
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
