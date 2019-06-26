package com.mian.SpringBootDemo.controller;

import com.mian.SpringBootDemo.domain.User;
import com.mian.SpringBootDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public static final String SUCCESS = "SUCCESS";
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

    @RequestMapping("name/{name}")
    public List<User> getUsersByNameV2(@PathVariable("name")String name) {
        return this.userService.findUserByName(name);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return this.userService.findAllUsers();
    }

    @RequestMapping("/delete/{name}")
    public String deleteUserByName(@PathVariable("name")String name) {
        this.userService.deleteUserByName(name);
        return SUCCESS;
    }


    @RequestMapping("/insert/{name}/{age}/{salary}")
    public User insertUser(@PathVariable("name") String name, @PathVariable("age") int age, @PathVariable("salary") int salary) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setSalary(salary);
        user.setCreateDate(new Date());
        return this.userService.insertUser(user);
    }

    @PostMapping("/insert")
    public User insertUser(@RequestBody User user) {
        user.setCreateDate(new Date());
        return this.userService.insertUser(user);
    }

}
