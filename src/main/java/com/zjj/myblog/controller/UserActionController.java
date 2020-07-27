package com.zjj.myblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjj.myblog.entity.User;
import com.zjj.myblog.entity.Userlog;
import com.zjj.myblog.entity.Usersign;
import com.zjj.myblog.mapper.UserMapper;
import com.zjj.myblog.mapper.UserlogMapper;
import com.zjj.myblog.mapper.UsersignMapper;
import com.zjj.myblog.service.UserService;
import com.zjj.myblog.service.UserlogService;
import com.zjj.myblog.service.UsersignService;
import com.zjj.myblog.utils.FileUpload;
import org.checkerframework.checker.units.qual.A;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    UserlogService userlogService;
    @Autowired
    UsersignService usersignService;
    @Autowired
    UserService userService;
    @Autowired
    FileUpload fileUpload;

    /**
     * 注册
     *
     * @param user
     * @param model
     * @param date
     * @param file
     * @return
     */
    @RequestMapping("/registerUser")
    public String register(User user, Model model, @RequestParam("date") String date, @RequestParam("file") MultipartFile file) {
        //设置生日
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate time = LocalDate.parse(date, dateTimeFormatter);
        user.setBirthday(time);
        //文件路径
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
        boolean save = userService.save(user);
        if (save) {
            return "user/login";
        } else {
            model.addAttribute("error", "注册失败");
            return "user/reg";
        }
    }

}
