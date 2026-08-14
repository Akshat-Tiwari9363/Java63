package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.jwt.model.Users;

@Service
public class AuthService {

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public String verify(Users users){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(users.getUsername());
        return "fail";
    }

}
