package com.mian.spring.security.action.helloword.authentication.userdetailsservice;

import com.mian.spring.security.action.helloword.domian.MyUser;
import com.mian.spring.security.action.helloword.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//@Service
public class CaptchaWebAuthenticationDetailsService implements UserDetailsService {

    @Autowired
    private MyUserMapper myUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserMapper.findByUsername(username);
        if (null == myUser) {
            throw new UsernameNotFoundException("不存在此用户");
        }
//        myUser.setUserName(username);
        //模拟数据库的密码已经加密，V1未指定加密方式，采用的是DelegatingPasswordEncoder，需要加前缀才能区分是哪一种加密方式
        myUser.setPassword("{bcrypt}" + passwordEncoder().encode(myUser.getPassword()));
        myUser.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(myUser.getRoles()));
        return myUser;
    }
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
