package com.mian.SpringBootDemo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean filterUser() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new UserFilter());
        bean.addInitParameter("encoding", "GB2312");
        bean.addUrlPatterns("/user/*");
        bean.setOrder(1);
        return bean;
    }

}
