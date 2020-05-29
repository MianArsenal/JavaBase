package com.mian.spring.security.action.helloword.exception;

public class CaptchaException extends ArithmeticException {

    public CaptchaException() {
        super("图形验证码校验失败");
    }
}
