package com.zjj.myblog.service.impl;

import com.zjj.myblog.entity.User;
import com.zjj.myblog.mapper.UserMapper;
import com.zjj.myblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2020-07-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public List<User> blogComment() {
        List<User> blogComment = userMapper.getBlogComment();
        return blogComment;
    }
}
