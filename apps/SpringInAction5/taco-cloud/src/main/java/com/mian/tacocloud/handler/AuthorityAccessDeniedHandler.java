package com.mian.tacocloud.handler;

import org.slf4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorityAccessDeniedHandler implements AccessDeniedHandler {

    private Logger logger;

    public AuthorityAccessDeniedHandler(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        this.logger.warn("Authority is not enough! + \n" + accessDeniedException.getMessage());
//        response.sendRedirect("/logout");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println("{\"code\":403,\"message\":\" Your authority is not enough!\",\"data\":\"\"}");
        response.getWriter().flush();
    }

}
