package com.example.springbootoauth2jwt.controller;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/user")
public class UserController {

    //获取当前用户
    @RequestMapping("/getUser")
    public Object getUser(Authentication authentication, HttpServletRequest httpServletRequest){
        String header=httpServletRequest.getHeader("Authorization");
        String token=header.substring(header.indexOf("bearer")+7);
        System.out.println(token);
        //return  authentication.getPrincipal();
        return Jwts.parser().setSigningKey("key_value".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
    }
}
