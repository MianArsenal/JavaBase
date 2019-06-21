package com.mian.SpringBootDemo.service;

import com.mian.SpringBootDemo.domain.User;

import java.util.List;

public interface UserService {

    List<User> findUserByName (String name);

}
