package com.security.controller;

import org.springframework.web.bind.annotation.RestController;

import com.security.model.Users;
import com.security.service.MyUserDetailsService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class SecurityController {

    @Autowired
    MyUserDetailsService service;

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Good Morning "+request.getRemoteUser()+"\nyour session ID :"+request.getSession().getId();
    }

    // @GetMapping("/csrf")
    // public CsrfToken getMethodName(HttpServletRequest request) {
    //     return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    // }
    

    @PostMapping("/register")
    public Users register(@RequestBody Users users) {
        return service.register(users);
    }
    
    
}
