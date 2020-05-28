package com.mian.spring.security.action.helloword.configuration;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Bean;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
        import org.springframework.security.core.Authentication;
        import org.springframework.security.core.AuthenticationException;
        import org.springframework.security.core.userdetails.User;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.security.provisioning.JdbcUserDetailsManager;
        import org.springframework.security.web.authentication.AuthenticationFailureHandler;
        import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.sql.DataSource;
        import java.io.IOException;
        import java.io.PrintWriter;

@EnableWebSecurity
public class WebSecurityConfigCustomJdbc extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/myLogin.html")
//                .loginProcessingUrl("/login") 没明白loginProcessingUrl的作用
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=UTF-8");
                        PrintWriter o = httpServletResponse.getWriter();
                        o.write("{\"error code\":\"0\", \"message\":\"登录成功！\"}");
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=UTF-8");
                        PrintWriter o = httpServletResponse.getWriter();
                        o.write("{\"error code\":\"401\", \"message\":\"登录失败！\"}");
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> configurer = auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
//        if (!configurer.getUserDetailsService().userExists("henry")) {
//            configurer.withUser("henry").password(passwordEncoder().encode("hahaha")).roles("USER");
//        }
//        if (!configurer.getUserDetailsService().userExists("baba")) {
//            configurer.withUser("baba").password(passwordEncoder().encode("hahaha")).roles("USER", "ADMIN");
//        }
//    }

//    private PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
