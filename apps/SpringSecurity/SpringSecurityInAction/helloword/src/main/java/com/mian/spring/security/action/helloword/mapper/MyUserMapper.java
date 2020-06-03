package com.mian.spring.security.action.helloword.mapper;

import com.mian.spring.security.action.helloword.domian.MyUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface MyUserMapper {

    @Select("SELECT * FROM myusers WHERE username=#{username}")
    MyUser findByUsername(@Param("username") String username);

}
