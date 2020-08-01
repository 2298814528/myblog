package com.zjj.myblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 热点的实体类
 */
@Data
public class HotBlog implements Serializable {
    private int id;
    private String title;
    private int comment_count;
}
