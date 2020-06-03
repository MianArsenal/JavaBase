package com.mian.spring.security.action.helloword.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

//@EnableWebSecurity
public class WebSecurityConfigRememberMeHash extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("captchaWebAuthenticationDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
        http.rememberMe().userDetailsService(this.userDetailsService);
        //key 是加密的盐，默认为UUID，且重启会重新生成，每个实例不一样，这里设置固定可以避免失效问题，但有安全风险
//        http.rememberMe().userDetailsService(this.userDetailsService).key("mian");
    }

}
