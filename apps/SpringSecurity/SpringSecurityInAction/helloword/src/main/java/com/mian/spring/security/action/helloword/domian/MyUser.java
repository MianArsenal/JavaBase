package com.mian.spring.security.action.helloword.domian;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/*
create table myusers(
	id bigint(20) not null auto_increment,
	username varchar(50) not null,
	password varchar(60),
	enable tinyint(4) not null default '1' comment '用户是否可用',
	roles text character set utf8 comment '用户角色，多个角色之间用逗号隔开',
	primary key(id),
	key username(username)
);

select * from myusers;
insert into myusers(username, password, enable, roles) values ("baba", "hahaha", 1, "ROLE_ADMIN,ROLE_USER");
insert into myusers(username, password, enable, roles) values ("henry", "hahaha", 1, "ROLE_USER");
*/

public class MyUser implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private String roles;
    private boolean enable;

//    @Getter(AccessLevel.NONE)
    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof MyUser && this.username.equals(((MyUser) o).getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
