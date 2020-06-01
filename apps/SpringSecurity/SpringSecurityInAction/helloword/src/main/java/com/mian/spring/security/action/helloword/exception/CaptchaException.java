package com.mian.spring.security.action.helloword.exception;


import org.springframework.security.core.AuthenticationException;

public class CaptchaException extends AuthenticationException {

    public CaptchaException() {
        super("图形验证码校验失败");
    }
}
