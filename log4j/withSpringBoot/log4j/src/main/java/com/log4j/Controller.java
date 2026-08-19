package com.log4j;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {

    @Autowired
    Service1 service;

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/")
    public String getMethodName() {
        logger.info("controler invoked");
        logger.debug("service invoked");
        String s=service.getMessage();
        logger.info("back to controller");
        return s;   
    }    

}
