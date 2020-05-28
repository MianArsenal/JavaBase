package com.mian.spring.security.action.helloword;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.mian.spring.security.action.helloword.mapper")
public class HellowordApplication {

    @GetMapping("/")
    public String hello() {
        return "hello! Spring security!";
    }

//    @PostMapping("/login")
//    public String login() {
//        return "login";
//    }

    public static void main(String[] args) {
        SpringApplication.run(HellowordApplication.class, args);
    }

}
