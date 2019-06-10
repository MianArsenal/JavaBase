package com.mian.SpringBootDemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/port")
    public String getPort() {
        return port;
    }

}
