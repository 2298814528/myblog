package com.zjj.myblog.service.impl;

import com.zjj.myblog.entity.User;
import com.zjj.myblog.mapper.UserMapper;
import com.zjj.myblog.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
