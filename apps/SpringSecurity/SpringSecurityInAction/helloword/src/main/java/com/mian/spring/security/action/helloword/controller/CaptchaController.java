package com.mian.spring.security.action.helloword.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class CaptchaController {

    @Autowired
    private Producer captchaProducer;

    @RequestMapping("/captcha.jpg")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setDateHeader("Expires", 0);
//        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
//        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
//        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = this.captchaProducer.createText();
        request.getSession().setAttribute("captcha", capText);
        BufferedImage bufferedImage = this.captchaProducer.createImage(capText);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(bufferedImage, "jpg", outputStream);
        outputStream.flush();
        outputStream.close();
    }

}