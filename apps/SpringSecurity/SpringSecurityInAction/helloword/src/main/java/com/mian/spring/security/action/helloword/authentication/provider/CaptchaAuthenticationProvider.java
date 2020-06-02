package com.mian.spring.security.action.helloword.authentication.provider;

import com.mian.spring.security.action.helloword.authentication.userdetails.CaptchaWebAuthenticationDetails;
import com.mian.spring.security.action.helloword.exception.CaptchaException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CaptchaAuthenticationProvider extends DaoAuthenticationProvider {

    public CaptchaAuthenticationProvider(@Qualifier("captchaWebAuthenticationDetailsServiceV2") UserDetailsService userDetailsService) {
        this.setUserDetailsService(userDetailsService);
        this.setPasswordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        //验证码验证
        CaptchaWebAuthenticationDetails details = (CaptchaWebAuthenticationDetails) authentication.getDetails();
        if (!details.isImageCodeIsRight()) {
            throw new CaptchaException();
        }
        //调用父类完成密码验证
        super.additionalAuthenticationChecks(userDetails, authentication);
    }
}
