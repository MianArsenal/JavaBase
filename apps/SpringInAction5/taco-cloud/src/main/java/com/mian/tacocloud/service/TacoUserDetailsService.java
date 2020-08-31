package com.mian.tacocloud.service;

import com.mian.tacocloud.domain.CustomUser;
import com.mian.tacocloud.repository.jpa.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TacoUserDetailsService implements UserDetailsService {

    private final JpaUserRepository jpaUserRepository;

    @Autowired
    public TacoUserDetailsService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = this.jpaUserRepository.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User: " + username + " not found!");
    }

}
