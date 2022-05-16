package com.example.springbootoauth2jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private PasswordEncoder pwd;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadbyuser方法");
        //1、数据库查询用户
        if (!"admin1".equals(username)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        //2、用户密码解析（加密后），或放入构造方法
        //System.out.println("userdetail");
        String password = pwd.encode("123");
        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList(
                "admin,normal,ROLE_abc,/select"));
    }

}

