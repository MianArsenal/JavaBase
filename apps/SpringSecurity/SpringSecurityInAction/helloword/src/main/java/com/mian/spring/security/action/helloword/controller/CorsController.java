package com.mian.spring.security.action.helloword.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cors/")
public class CorsController {

    @RequestMapping("hello")
    @CrossOrigin(origins = "http://localhost:8083", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
    public String helloCors() {
        return "Hello CORS!";
    }

    @RequestMapping("hi")
    public String hiCors() {
        return "Hi CORS!";
    }

}
