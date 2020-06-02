package com.mian.spring.security.action.helloword.configuration;

import com.mian.spring.security.action.helloword.filter.CaptchaFilter;
import com.mian.spring.security.action.helloword.authentication.handler.CaptchaExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

//@EnableWebSecurity
public class WebSecurityConfigCustomCaptcha extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**", "/captcha.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/myLoginCaptcha.html").permitAll()
                .loginProcessingUrl("/auth/form").permitAll()
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=UTF-8");
                        PrintWriter o = httpServletResponse.getWriter();
                        o.write("{\"error code\":\"0\", \"message\":\"登录成功！\"}");
                    }
                })
                .failureHandler(new CaptchaExceptionHandler())
                .permitAll()
                .and()
                .csrf().disable();
        http.addFilterBefore(new CaptchaFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
