package com.zjj.myblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjj.myblog.entity.Post;
import com.zjj.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class PostController {
    @Autowired
    PostService postService;

    /**
     * 发布新的博客
     *
     * @return
     */
    @RequestMapping("/add")
    public String add() {
        return "option/add";
    }


    @ResponseBody
    @RequestMapping("/blog")
    public Map blog(long current, HttpServletRequest request) {
        HttpSession session = request.getSession();
        IPage ipage = new Page(current, 5);
        IPage page = postService.page(ipage, null);
        List records = page.getRecords();
        session.setAttribute("records", records);
        return new HashMap();
    }

    @RequestMapping("/addBlog")
    public String addBlog() {
        return "user/home";
    }

}
