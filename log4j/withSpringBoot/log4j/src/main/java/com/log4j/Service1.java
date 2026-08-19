package com.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Service1 {

    private static final Logger logger = LoggerFactory.getLogger(Service1.class);


    public String getMessage() {
        logger.trace("service invoked");
        return "hello world";
    }
    
}
