package com.zjj.myblog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjj.myblog.entity.User;
import com.zjj.myblog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MyblogApplicationTests {


    @Test
    void contextLoads() {
    }

    @Test
    void find(){
//        List<User> users = userMapper.selectList(null);
//        users.forEach(user -> System.out.println("user = "+user));
    }
    @Test
    void findOne(){
//        LocalDateTime now = LocalDateTime.now();
//        Timestamp timestamp = Timestamp.valueOf(now);
//        System.out.println(timestamp);
//        User id = userMapper.selectOne(new QueryWrapper<User>().eq("id", 1));
//        System.out.println(id);
//        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", "224").eq("password", "224"));
//        System.out.println(user);
//        LocalDate now = LocalDate.now();
//        System.out.println(now.toString());
//        Integer integer = null;
//        System.out.println(integer.equals(0));
//        System.out.println(integer.equals(new Integer(0)));
//        System.out.println(integer == 0);
//        System.out.println(integer == new Integer(0));

//        String s = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
//        System.out.println(s);
//        Date date = new Date();
//        System.out.println(date.toString());
//        System.out.println(date);
        String s = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate time = LocalDate.parse(s, dateTimeFormatter);
        System.out.println(time);
        System.out.println("______________________________");
        System.out.println(LocalDate.now());
    }

}
