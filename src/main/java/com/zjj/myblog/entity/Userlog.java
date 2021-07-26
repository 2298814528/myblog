package com.zjj.myblog.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 登录表
 * </p>
 *
 * @author author
 * @since 2020-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Userlog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @TableField("USER")
    private String user;

    /**
     * 登陆时间
     */
    @TableField("logTime")
    private Timestamp logTime;


}
