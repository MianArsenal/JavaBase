package com.mian.SpringBootDemo.controller;

import com.whalin.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/memcache")
public class MemCachedController {

    public static final String SUCCESS = "success";
    @Autowired
    private MemCachedClient memCachedClient;

    @RequestMapping("/test")
    @ResponseBody
    public String memcache() throws InterruptedException {
        memCachedClient.set("master", "MiAn");
        System.out.println(memCachedClient.get("master"));
        //设置过期时间
        memCachedClient.set("temporary", "Henry Mi", new Date(3000));
        System.out.println(memCachedClient.get("temporary"));
        Thread.sleep(3000);
        System.out.println(memCachedClient.get("master"));
        System.out.println(memCachedClient.get("temporary"));
        return SUCCESS;
    }

}
