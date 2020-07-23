package com.mian.spring.security.action.helloword.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

@EnableRedisHttpSession
public class HttpSessionConfig {

    /*
    * 默认localhost:6379
    * */
    @Bean
    public RedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();
    }

    @Autowired
    private FindByIndexNameSessionRepository sessionRepository;

    /*
     * 用于在集群环境下控制session并发的session注册表实现类
     */
    @Bean
    public SpringSessionBackedSessionRegistry sessionRegistry(){
        return new SpringSessionBackedSessionRegistry(this.sessionRepository);
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher () {
        return new HttpSessionEventPublisher();
    }

}
