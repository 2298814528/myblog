package com.zjj.myblog.service.impl;

import com.zjj.myblog.entity.Comment;
import com.zjj.myblog.mapper.CommentMapper;
import com.zjj.myblog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2020-07-12
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
