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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        User user = userService.getOne(userQueryWrapper);
        if (user == null) {
            model.addAttribute("error", "账号或密码错误");
            return "user/login";
        } else {
//            插入登录表
            Userlog userlog = new Userlog();
            userlog.setLogTime(Timestamp.valueOf(LocalDateTime.now()));
            userlog.setUser(username);
            userlogService.save(userlog);
            QueryWrapper<Userlog> userLog = new QueryWrapper<Userlog>().eq("user", username).eq("signTime", LocalDate.now());
//            判断是否签到
            QueryWrapper<Usersign> userSign = new QueryWrapper<Usersign>().eq("user", username).eq("signTime", LocalDate.now());
            Map<String, Object> map = usersignService.getMap(userSign);
            if (map == null) {
//                未签到
                session.setAttribute("signIn", "0");
            } else {
//                签到了
                session.setAttribute("signIn", "1");
            }
//            累计签到天数
            int dayCount = usersignService.count(new QueryWrapper<Usersign>().eq("user", username));
//            传入前端累计登陆天数
            session.setAttribute("day", dayCount);
//            传入前端用户名
            session.setAttribute("username", username);
//            传入前端头像位置
            session.setAttribute("avatar", user.getAvatar());
//            传入VIP等级
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
        boolean save = userService.save(user);
        if (save) {
            return "user/login";
        } else {
            model.addAttribute("error", "注册失败");
            return "user/reg";
        }
    }
}
