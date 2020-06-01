package com.mian.spring.security.action.helloword.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CaptchaExceptionHandler implements AuthenticationFailureHandler {

    public static final String EXCEPTION_CODE_CAPTCHA_EXCEPTION = "CAPTCHA_EXCEPTION";
    protected final Log logger = LogFactory.getLog(this.getClass());

    private String exceptionCode;

    public CaptchaExceptionHandler() {
    }

    public CaptchaExceptionHandler(String exceptionInfo) {
        this.exceptionCode = exceptionInfo;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        if (CaptchaExceptionHandler.EXCEPTION_CODE_CAPTCHA_EXCEPTION.equals(this.exceptionCode)) {
            this.logger.debug("验证码不正确");
            writer.write("{\"error code\":\"HttpStatus.UNAUTHORIZED.value()\", \"message\":\"验证码不正确！\"}");
        } else {
            this.logger.debug("用户名或者密码不正确");
            writer.write("{\"error code\":\"HttpStatus.UNAUTHORIZED.value()\", \"message\":\"用户名或者密码不正确！\"}");
        }
    }
}
