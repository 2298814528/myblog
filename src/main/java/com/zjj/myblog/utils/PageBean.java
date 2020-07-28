package com.zjj.myblog.utils;

import com.zjj.myblog.entity.Blog_User;
import lombok.Data;

/**
 * 用于分页的工具类
 */
@Data
public class PageBean {
    /**
     * 当前页数
     */
    private long current;
    /**
     * 多少条记录
     */
    private long size;
}
