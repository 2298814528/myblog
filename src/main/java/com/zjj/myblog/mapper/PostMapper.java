package com.zjj.myblog.mapper;

import com.zjj.myblog.entity.Blog_User;
import com.zjj.myblog.entity.HotBlog;
import com.zjj.myblog.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2020-07-12
 */
public interface PostMapper extends BaseMapper<Post> {

    List<Blog_User> listByPageLevel(Integer current,Integer size);

    List<Blog_User> listByPageAll(Integer current, Integer size);

    List<HotBlog> getHot();
}
