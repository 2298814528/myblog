package com.zjj.myblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjj.myblog.entity.Post;
import com.zjj.myblog.entity.User;
import com.zjj.myblog.service.PostService;
import com.zjj.myblog.service.UserService;
import com.zjj.myblog.utils.CheckCode;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
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
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CheckCode checkCode;
    @Autowired
    PostService postService;

    /**
     * 注册跳转
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
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
//        置顶的帖子
        IPage ipageLevel = new Page(1,5);
        QueryWrapper<Post> levelQW = new QueryWrapper<Post>().eq("level",1);
        IPage pageLevel = postService.page(ipageLevel, levelQW);
        List recordsLevel = pageLevel.getRecords();
        session.setAttribute("level",recordsLevel);
//        所有的帖子
        IPage ipageAll = new Page(1,10);
        IPage pageAll = postService.page(ipageAll, null);
        List recordsAll = pageAll.getRecords();
        session.setAttribute("records",recordsAll);
        session.setAttribute("total",pageAll.getTotal());
        return "index";
    }

    /**
     * 主页
     *
     * @return
     */
    @RequestMapping("/")
    public String indexs(HttpServletRequest request) {
        HttpSession session = request.getSession();
//        置顶的帖子
        IPage ipageLevel = new Page(1,5);
        QueryWrapper<Post> levelQW = new QueryWrapper<Post>().eq("level",1);
        IPage pageLevel = postService.page(ipageLevel, levelQW);
        List recordsLevel = pageLevel.getRecords();
        session.setAttribute("level",recordsLevel);
//        所有的帖子
        IPage ipageAll = new Page(1,10);
        IPage pageAll = postService.page(ipageAll, null);
        List recordsAll = pageAll.getRecords();
        session.setAttribute("all",recordsAll);
        session.setAttribute("total",pageAll.getTotal());
        return "index";

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

    @RequestMapping("/detail/{id:\\d*}")
    public String detail(@PathVariable(name = "id")Long id){
        return "option/detail";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }


}
