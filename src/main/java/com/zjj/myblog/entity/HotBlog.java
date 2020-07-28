package com.zjj.myblog.entity;

import lombok.Data;

/**
 * 热点的实体类
 */
@Data
public class HotBlog {
    private int id;
    private String title;
    private int comment_count;
}
