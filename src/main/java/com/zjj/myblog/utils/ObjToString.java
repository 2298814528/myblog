package com.zjj.myblog.utils;

import com.zjj.myblog.entity.Blog_User;
import com.zjj.myblog.entity.HotBlog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于Object转为HotBlog对象
 */
@Component
public class ObjToString {
    public List<HotBlog> Conversion(List hot) {
        List<HotBlog> list = new ArrayList<>();
        if (hot.size() > 0) {
            for (int i = 0; i < hot.size(); i++) {
                String str = hot.get(i).toString();
                String[] split = str.split("[,=()]");
                HotBlog hotBlog = new HotBlog();
                if (split.length >= 7) {
                    int id = Integer.parseInt(split[2]);
                    String title = split[4];
                    int comment_count = Integer.parseInt(split[6]);
                    hotBlog.setComment_count(comment_count);
                    hotBlog.setId(id);
                    hotBlog.setTitle(title);
                }
                list.add(hotBlog);
            }
        }
        return list;
    }
}
