package com.zjj.myblog.service.impl;

import com.zjj.myblog.entity.UserMessage;
import com.zjj.myblog.mapper.UserMessageMapper;
import com.zjj.myblog.service.UserMessageService;
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
public class UserMessageServiceImpl extends ServiceImpl<UserMessageMapper, UserMessage> implements UserMessageService {

}
