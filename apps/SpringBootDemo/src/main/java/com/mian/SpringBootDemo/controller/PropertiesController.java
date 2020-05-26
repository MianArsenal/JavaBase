package com.mian.SpringBootDemo.controller;

import com.mian.SpringBootDemo.configuration.CustomConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
@EnableConfigurationProperties(CustomConfiguration.class)
public class PropertiesController {

    @Value("${server.port}")
    private String port;
    @Value("${master.name}")
    private String masterName;
    @Value("${master.age}")
    private String masterAge;
    @Autowired
    private CustomConfiguration customConfiguration;

    @RequestMapping("/port")
    public String getPort() {
        return port;
    }

    @RequestMapping("/master")
    public String getMaster() {
        return "[" + customConfiguration.getName() + ":" + customConfiguration.getAge() + "]";
    }

    @RequestMapping("/masterName")
    public String getMasterName() {
        return this.masterName;
    }

    @RequestMapping("/masterAge")
    public String getMasterAge () {
        return this.masterAge;
    }

}
