package com.zjj.myblog;

import com.zjj.myblog.entity.User;
import com.zjj.myblog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void find(){
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> System.out.println("user = "+user));
    }

}
