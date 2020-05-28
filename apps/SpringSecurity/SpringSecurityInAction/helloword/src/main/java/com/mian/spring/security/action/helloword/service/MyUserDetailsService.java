package com.mian.spring.security.action.helloword.service;

import com.mian.spring.security.action.helloword.domian.MyUser;
import com.mian.spring.security.action.helloword.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserMapper myUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserMapper.findByUserName(username);
        if (null == myUser) {
            throw new UsernameNotFoundException("不存在此用户");
        }
        //模拟数据库的密码已经加密
        myUser.setPassword("{bcrypt}" + passwordEncoder().encode(myUser.getPassword()));
        myUser.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(myUser.getRoles()));
        return myUser;
    }
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    private List<GrantedAuthority> generateAuthorities(String roles) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String role: roles.split(";")) {
//            authorities.add(new SimpleGrantedAuthority(role));
//        }
//        return authorities;
//    }
}
