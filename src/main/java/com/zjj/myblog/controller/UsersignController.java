package com.zjj.myblog.controller;


import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjj.myblog.entity.User;
import com.zjj.myblog.entity.Usersign;
import com.zjj.myblog.mapper.UsersignMapper;
import com.zjj.myblog.service.UserService;
import com.zjj.myblog.service.UsersignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    UserService userService;
    @Autowired
    UsersignService usersignService;

    @RequestMapping("/signIn")
    @ResponseBody
    public Map<String, String> sign(HttpServletRequest request) {
        Map map = new HashMap();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        LocalDate now = LocalDate.now();
        Usersign usersign = new Usersign();
        usersign.setSignTime(now);
        usersign.setUser(username);
        boolean save = usersignService.save(usersign);
        if (save) {
            QueryWrapper<User> userWrapper = new QueryWrapper<User>().eq("username", username);
            User user = userService.getOne(userWrapper);
            int point = user.getPoint();
            point = point + 5;
            user.setPoint(point);
            boolean update = userService.update(user, userWrapper);
            if (update) {
                session.setAttribute("signIn", "1");
                map.put("msg", "签到成功");
                return map;
            } else {
                session.setAttribute("signIn", "1");
                map.put("msg", "签到失败");
                return map;
            }
        } else {
            session.setAttribute("signIn", "1");
            map.put("msg", "签到失败");
            return map;
        }
    }
}
