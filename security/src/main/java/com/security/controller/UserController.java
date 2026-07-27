package com.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.User;
import com.security.service.MyUserDetailService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    MyUserDetailService userDetailService;

    @GetMapping("/")
    public String getMethodName(HttpServletRequest req) {
        return "Hello "+req.getRemoteUser();
    }
    

    @GetMapping("/{username}")
    public User getMethodName(@PathVariable String username) {
        return userDetailService.findUser(username);
    }

    @PostMapping("/loves")
    public User loves(@RequestBody User user) {
        return userDetailService.register(user);        
    }
    
    

}
