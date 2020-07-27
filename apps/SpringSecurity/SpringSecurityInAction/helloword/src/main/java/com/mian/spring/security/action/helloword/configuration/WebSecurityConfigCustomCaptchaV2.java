package com.mian.spring.security.action.helloword.configuration;

import com.mian.spring.security.action.helloword.authentication.handler.CaptchaExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@EnableWebSecurity
public class WebSecurityConfigCustomCaptchaV2 extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("captchaWebAuthenticationDetailsSource")
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> captchaWebAuthenticationDetailsSource;

    @Autowired
    @Qualifier("captchaAuthenticationProvider")
    private AuthenticationProvider captchaAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.captchaAuthenticationProvider);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**", "/captcha.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //应用detail source包装额外信息到user detail，等到provider调用时获得额外信息进行额外验证
                .authenticationDetailsSource(this.captchaWebAuthenticationDetailsSource)
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
    }

}
