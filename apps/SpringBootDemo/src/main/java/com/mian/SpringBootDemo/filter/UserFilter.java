package com.mian.SpringBootDemo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserFilter implements Filter {

    private FilterConfig filterConfig;
    private String paramValue;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.paramValue = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext context = this.filterConfig.getServletContext();
        context.log("-----filter user-----");
        context.log("paramValue:" + paramValue);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        context.log(request.getServletPath());
        context.log(request.getRequestURI());
        context.log(request.getServerName());
        context.log(request.getPathInfo());
        context.log(request.getLocalName());
        context.log(request.getRemoteHost());
        context.log(request.getAuthType());
        context.log(request.getAttributeNames().toString());
        context.log(request.getParameterNames().toString());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
        this.paramValue = null;
    }
}
