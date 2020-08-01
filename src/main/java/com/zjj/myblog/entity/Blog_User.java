package com.zjj.myblog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用于主页显示各项参数
 */
//post.id,post.title,post.content,post.comment_count,post.recommend,post.level,post.created,user.username,
//        user.vip_level,user.avatar
@Data
public class Blog_User implements Serializable {

    /**
     * id
     */
    private int id;

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
     * 状态（已结、未结）
     */
    private int status;

    /**
     * 置顶等级
     */
    private Integer level;

    /**
     * 发布时间
     */
    private Timestamp created;

    /**
     * 积分
     */
    private Integer integral;

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


}
