package com.zjj.myblog.controller;


import com.zjj.myblog.entity.Usersign;
import com.zjj.myblog.mapper.UsersignMapper;
import com.zjj.myblog.service.UsersignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 签到表 前端控制器
 * </p>
 *
 * @author author
 * @since 2020-07-14
 */
@RestController
public class UsersignController {
    @Autowired
    UsersignService usersignService;
    @RequestMapping("/signIn")
    public String sign(@RequestParam("user")String user){
        LocalDate now = LocalDate.now();
        Usersign usersign = new Usersign();
        usersign.setSignTime(now);
        usersign.setUser(user);
        boolean save = usersignService.save(usersign);
        if (save){
            return "签到成功";
        }else {
            return "签到失败";
        }
    }
}
