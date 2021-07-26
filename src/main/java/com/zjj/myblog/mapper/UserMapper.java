package com.zjj.myblog.mapper;

import com.zjj.myblog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author author
 * @since 2020-07-12
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 回帖总榜
     *
     * @return
     */

    List<User> getBlogComment();
}
