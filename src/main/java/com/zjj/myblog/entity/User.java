package com.zjj.myblog.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author author
 * @since 2020-07-12
 */
@Data
@Setter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮件
     */
    private String email;

    /**
     * 手机电话
     */
    private String mobile;

    /**
     * 积分
     */
    private Integer point;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 性别
     */
    private String gender;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * vip等级
     */
    private Integer vipLevel;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 内容数量
     */
    private Integer postCount;

    /**
     * 评论数量
     */
    private Integer commentCount;

    /**
     * 最后的登陆时间
     */
    private Timestamp lasted;
    /**
     * 状态
     */
    @TableField("status")
    private int status;
    /**
     * 创建日期
     */
    @TableField("created")
    private Timestamp created;
    /**
     * 最后修改的时间
     */
    @TableField("modified")
    private Timestamp modified;

}
