package com.zjj.myblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zjj.myblog.mapper")
public class MyblogApplication {

    public static void main(String[] args) {
        System.out.println("http://localhost:8081/");
        SpringApplication.run(MyblogApplication.class, args);
    }

}
