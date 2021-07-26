package com.zjj.myblog.service;

import com.zjj.myblog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author author
 * @since 2020-07-12
 */
public interface UserService extends IService<User> {
    /**
     * 回帖总榜
     */
    List<User> blogComment();

}
