package com.mian.spring.security.action.helloword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping("/login")
    public String loginPage() {
        return "myLoginCsrf";
    }

    @RequestMapping("/csrf")
    @CrossOrigin(origins = "http://localhost:8083", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
    public String csrf() {
        return "csrf";
    }

    @RequestMapping("/csrfAnswer")
    public String csrfAnswer() {
        return "csrfAnswer";
    }
}
