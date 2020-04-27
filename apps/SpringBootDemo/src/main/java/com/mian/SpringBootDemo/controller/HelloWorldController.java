package com.mian.SpringBootDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/service")
    public String test() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.addHeader("ART_RequestSize", "-1");
        response.addHeader("ART_RRT", "1587952641890");
        response.addHeader("ART_RST", "1587952642011");
        response.addHeader("Connection", "Keep-Alive");
        response.addHeader("Content-Language", "en");
        response.addHeader("Content-Length", "243");
        response.addHeader("Content-Type", "application/xml");
        response.addHeader("Date", "Mon, 27 Apr 2020 01:57:21 GMT");
        response.addHeader("Keep-Alive", "timeout=15, max=2000");
        response.addHeader("Server", "Oracle-Application-Server-11g");
        response.addHeader("Set-Cookie", "JSESSIONID=yLzCpm8BLLk0kSn1f3FQBhzyfnLLP6Qm965LsWMZnykZQRvGrw2n!-1024998691; path=/; HttpOnly");
        response.addHeader("Set-Cookie", "BIGipServerpool_backend_cs4dom_5000=570888364.24862.0000; path=/");
        response.addHeader("X-Powered-By", "Servlet/2.5 JSP/2.1");
        return "";
    }

}
