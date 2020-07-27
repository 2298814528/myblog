package com.zjj.myblog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 用于主页显示各项参数
 */
@Data
public class Blog_User {
    /**
     * 昵称
     */
    private String username;

    /**
     * vip等级
     */
    private Integer vipLevel;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 评论数量
     */
    private Integer commentCount;

    /**
     * 是否为精华
     */
    private Boolean recommend;

    /**
     * 置顶等级
     */
    private Integer level;

    /**
     * 发布时间
     */
    @TableField("created")
    private Timestamp created;
}
