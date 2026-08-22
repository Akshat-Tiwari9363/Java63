package com.demo;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class HelloController {

    @Hidden
    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws Exception {
        response.sendRedirect("/swagger-ui.html");
    }
    

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    

}
