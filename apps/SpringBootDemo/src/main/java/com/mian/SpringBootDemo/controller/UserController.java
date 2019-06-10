package com.mian.SpringBootDemo.controller;

import com.mian.SpringBootDemo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/default")
    public User getDefaultUser() {
        User mian = new User();
        mian.setAge(100);
        mian.setName("MiAn");
        return mian;
    }

}
