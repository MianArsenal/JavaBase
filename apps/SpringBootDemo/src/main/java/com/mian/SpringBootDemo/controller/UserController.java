package com.mian.SpringBootDemo.controller;

import com.mian.SpringBootDemo.domain.User;
import com.mian.SpringBootDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/default")
    public User getDefaultUser() {
        User mian = new User();
        mian.setAge(100);
        mian.setName("MiAn");
        return mian;
    }

    @RequestMapping("/name")
    public List<User> getUsersByName(@RequestParam("name")String name) {
        return this.userService.findUserByName(name);
    }

}
