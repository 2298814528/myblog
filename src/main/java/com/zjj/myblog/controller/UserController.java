package com.zjj.myblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjj.myblog.entity.User;
import com.zjj.myblog.service.UserService;
import com.zjj.myblog.utils.CheckCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
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
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CheckCode checkCode;


    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login")
    public String loginHtml() {
        return "user/login";
    }

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping("/register")
    public String registerHTML() {
        return "user/reg";
    }

    /**
     * 所用技术
     *
     * @return
     */
    @RequestMapping("/technology")
    public String technology() {
        return "catalog";
    }

    /**
     * 主页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpSession session) {
        return "index";
    }

    /**
     * 发布新的博客
     * @return
     */
    @RequestMapping("/add")
    public String add() {
        return "option/add";
    }

    /**
     * 用户中心
     * @param request
     * @return
     */
    @RequestMapping("/home")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        session.setAttribute("point", user.getPoint());
        return "user/home";
    }

    /**
     * 用户信息设置
     * @param request
     * @return
     */
    @RequestMapping("/set")
    public String set(HttpServletRequest request) {
        return "user/set";
    }

    /**
     * 用户消息
     * @return
     */
    @RequestMapping("/message")
    public String message() {
        return "user/message";
    }

    /**
     * 邮箱激活
     * @return
     */
    @RequestMapping("/active")
    public String active() {
        return "user/active";
    }

    /**
     * 用户主页
     * @return
     */
    @RequestMapping("/user/index")
    public String index() {
        return "/user/index";
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logOut(HttpServletRequest request) {
        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            request.getSession().removeAttribute(attributeNames.nextElement().toString());
        }
        return "index";
    }

    /**
     * 生成验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/code")
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        checkCode = new CheckCode(120, 36, 5, 10);
        ImageIO.write(checkCode.getBuffImg(), "jpg", response.getOutputStream());
    }

    /**
     * 发送异步获取验证码
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/codes")
    public Map<String,String> codes(HttpServletRequest request) throws IOException {
        Map<String,String> map=new HashMap<String, String>();
        String code = checkCode.getCode();
        map.put("code",code);
        return map;
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }


}
