package com.zjj.myblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjj.myblog.entity.User;
import com.zjj.myblog.mapper.UserMapper;
import com.zjj.myblog.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2020-07-12
 */
@Controller
public class UserActionController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    FileUpload fileUpload;

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/loginUser")
    public String login(String username, String password, Model model, HttpSession session) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>().eq("username", username).eq("password", password);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            model.addAttribute("error", "账号或密码错误");
            return "user/login";
        } else {
            session.setAttribute("username", username);
            session.setAttribute("avatar", user.getAvatar());
            session.setAttribute("signIn", user.getSingIn());
            session.setAttribute("vipLevel", "VIP" + user.getVipLevel());
            return "redirect:/index";
        }
    }

    /**
     * 注册
     *
     * @param user
     * @param model
     * @param date
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/registerUser")
    public String register(User user, Model model, @RequestParam("date") String date, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //设置生日
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate time = LocalDate.parse(date, dateTimeFormatter);
        user.setBirthday(time);
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "\\src\\main\\resources\\static\\upload";
        try {
            String fileName = fileUpload.upload(file, path);
            user.setAvatar(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDateTime now = LocalDateTime.now();
        user.setCreated(Timestamp.valueOf(now));
        user.setModified(Timestamp.valueOf(now));
        int insert = userMapper.insert(user);
        if (insert > 0) {
            return "user/login";
        } else {
            model.addAttribute("error", "注册失败");
            return "user/reg";
        }
    }
}
