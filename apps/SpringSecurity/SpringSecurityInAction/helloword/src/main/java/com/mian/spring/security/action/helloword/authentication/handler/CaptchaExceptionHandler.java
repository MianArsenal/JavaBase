package com.mian.spring.security.action.helloword.authentication.handler;

import com.mian.spring.security.action.helloword.exception.CaptchaException;
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

    protected final Log logger = LogFactory.getLog(this.getClass());

    public CaptchaExceptionHandler() {
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        if (e instanceof CaptchaException) {
            this.logger.debug("验证码不正确");
            writer.write("{\"error code\":\"401\", \"message\":\"验证码不正确！\"}");
        } else {
            this.logger.debug("用户名或者密码不正确");
            writer.write("{\"error code\":\"401\", \"message\":\"用户名或者密码不正确！\"}");
        }
    }
}
