package com.mian.spring.security.action.helloword.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cors/")
public class CorsController {

    @RequestMapping("hello")
    public String helloCors() {
        return "Hello CORS!";
    }

    @RequestMapping("hi")
    public String hiCors() {
        return "Hi CORS!";
    }

}
