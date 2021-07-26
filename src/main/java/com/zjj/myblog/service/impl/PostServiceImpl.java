package com.zjj.myblog.service.impl;

import com.zjj.myblog.entity.Blog_User;
import com.zjj.myblog.entity.HotBlog;
import com.zjj.myblog.entity.Post;
import com.zjj.myblog.entity.User;
import com.zjj.myblog.mapper.PostMapper;
import com.zjj.myblog.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjj.myblog.utils.ObjToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2020-07-12
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    @Autowired
    ObjToString objToString;

    @Resource
    PostMapper postMapper;

    /**
     * 分页查询置顶
     *
     * @param current
     * @param size
     * @return
     */
    @Override
    public List<Blog_User> listByPageLevel(Integer current, Integer size) {
        List<Blog_User> blog_usersLevel = postMapper.listByPageLevel(current, size);
        return blog_usersLevel;
    }

    /**
     * 分页查询总的帖子
     *
     * @param current
     * @param size
     * @return
     */
    @Override
    public List<Blog_User> listByPageAll(Integer current, Integer size) {
        List<Blog_User> blog_usersAll = postMapper.listByPageAll(current, size);
        return blog_usersAll;
    }

    /**
     * 本周热议
     *
     * @return
     */
    @Override
    public List<HotBlog> hot() {
        List<HotBlog> hot = postMapper.getHot();
        List<HotBlog> conversion = objToString.Conversion(hot);
        return conversion;
    }

    @Override
    public Blog_User selectOne(int id) {
        Blog_User blog_user = postMapper.getOne(id);
        return blog_user;
    }

}
