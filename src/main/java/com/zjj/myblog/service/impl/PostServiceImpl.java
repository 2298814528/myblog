package com.zjj.myblog.service.impl;

import com.zjj.myblog.entity.Post;
import com.zjj.myblog.mapper.PostMapper;
import com.zjj.myblog.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2020-07-11
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}
