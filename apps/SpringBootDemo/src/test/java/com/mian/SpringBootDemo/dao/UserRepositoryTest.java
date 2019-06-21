package com.mian.SpringBootDemo.dao;

import com.mian.SpringBootDemo.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
    }

    @Test
    public void test() {
        User miAn = userRepository.save(new User("MiAn", 100, 10000, new Date()));
        User henry_mi = userRepository.save(new User("Henry Mi", 100, 10000, new Date()));
        Assert.assertEquals(1, userRepository.findByName("MiAn").size());
        Assert.assertEquals(1, userRepository.findByName("Henry Mi").size());
        userRepository.delete(miAn);
        userRepository.delete(henry_mi);
    }

    @After
    public void tearDown() {
    }
}