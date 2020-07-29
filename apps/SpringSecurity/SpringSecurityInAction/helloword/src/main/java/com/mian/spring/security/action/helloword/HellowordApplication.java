package com.mian.spring.security.action.helloword;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@SpringBootApplication
@MapperScan("com.mian.spring.security.action.helloword.mapper")
public class HellowordApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellowordApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "hello! Spring security!";
    }

    /*
    验证码实例
     */
    @Bean
    public Producer captcha() {
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", "150");
        properties.setProperty("kaptcha.image.height", "50");
        properties.setProperty("kaptcha.textproducer.char.string", "0123456789");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        Config config = new Config(properties);
        DefaultKaptcha cha = new DefaultKaptcha();
        cha.setConfig(config);
        return cha;
    }

}
