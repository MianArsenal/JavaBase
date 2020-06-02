package com.mian.spring.security.action.helloword.filter;

import com.mian.spring.security.action.helloword.exception.CaptchaException;
import com.mian.spring.security.action.helloword.authentication.handler.CaptchaExceptionHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CaptchaFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if ("/auth/form".equals(httpServletRequest.getRequestURI())) {
            try {
                verifyCaptcha(httpServletRequest);
            } catch (CaptchaException e) {
                new CaptchaExceptionHandler().onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void verifyCaptcha(HttpServletRequest httpServletRequest) throws CaptchaException {
        String requestCode = httpServletRequest.getParameter("captcha");
        HttpSession session = httpServletRequest.getSession();
        String captchaInSession = (String) session.getAttribute("captcha");
        if (!StringUtils.isEmpty(captchaInSession)) {
            session.removeAttribute("captcha");
        }
        if (StringUtils.isEmpty(requestCode) || !requestCode.equals(captchaInSession)) {
            throw new CaptchaException();
        }
    }
}
