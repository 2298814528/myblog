package com.zjj.myblog.service;

import com.zjj.myblog.entity.Blog_User;
import com.zjj.myblog.entity.HotBlog;
import com.zjj.myblog.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjj.myblog.entity.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2020-07-12
 */
public interface PostService extends IService<Post> {
    /**
     * 分页查询置顶
     * @param current
     * @param size
     * @return
     */
    List<Blog_User> listByPageLevel(Integer current,Integer size);

    /**
     * 分页查询总的帖子
     * @param current
     * @param size
     * @return
     */
    List<Blog_User> listByPageAll(Integer current,Integer size);

    /**
     * 本周热议
     * @return
     */
    List<HotBlog> hot();

    /**
     * 查询单张帖子
     * @param id
     * @return
     */
    Blog_User selectOne(int id);
}
