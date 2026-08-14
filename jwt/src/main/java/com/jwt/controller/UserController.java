package com.jwt.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.Users;
import com.jwt.service.AuthService;
import com.jwt.service.MyUsersDetailService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

    @Autowired
    MyUsersDetailService service;

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public Users register(@RequestBody Users users) {
        return service.register(users);
    }
    
    @PostMapping("/token")
    public String login(@RequestBody Users users) {
        return authService.verify(users);
    }
    
    @GetMapping("/")
    public List<String> getAllUsers() {
        return service.findAllUsername();
    }
    

}
