package com.example.springbootoauth2jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
public class RedisConfig {
//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;
//    @Bean
//    public TokenStore redistokenStore(){
//        return new RedisTokenStore(redisConnectionFactory);
//    }
}