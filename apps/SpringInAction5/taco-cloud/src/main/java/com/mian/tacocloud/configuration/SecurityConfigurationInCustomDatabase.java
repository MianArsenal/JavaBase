package com.mian.tacocloud.configuration;

import com.mian.tacocloud.handler.AuthorityAccessDeniedHandler;
import com.mian.tacocloud.service.TacoUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfigurationInCustomDatabase extends WebSecurityConfigurerAdapter {

    private final TacoUserDetailsService tacoUserDetailsService;

    @Autowired
    public SecurityConfigurationInCustomDatabase(TacoUserDetailsService tacoUserDetailsService) {
        this.tacoUserDetailsService = tacoUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/h2-console", "/h2-console/**", "/register", "/images/*", "/css/*", "/activemq/**", "/favicon.ico").permitAll()
                .anyRequest().authenticated()
                .and().exceptionHandling().accessDeniedHandler(new AuthorityAccessDeniedHandler(log))
                .and().csrf().ignoringAntMatchers("/h2-console/**")
                .and().headers().frameOptions().sameOrigin()
                .and().csrf().disable().formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.tacoUserDetailsService)
        .passwordEncoder(encoder());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
