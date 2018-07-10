package com.amwater.microservices.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${welcome.message}")
	private String message;

	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(Exception ex) {
		return "The welcome null pointer exception has been caught!";
	}

	@GetMapping({"/","/welcome"})
    public String welcome() {
    	logger.info("Welcome message displayed!"); 
    
        return message; 
    }

    @GetMapping("/welcome/exception")
    public String welcomeException() {
    	if ("1".equals("1")) {
    		throw new java.lang.NullPointerException("Null pointer exception is thrown.");
    	}
    	
        return "Should not have gotten here."; 
    }

    @GetMapping("/welcome/exception/global")
    public String welcomeExceptionGlobal() {
    	if ("1".equals("1")) {
    		throw new java.lang.RuntimeException("Runtime exception is thrown.");
    	}
    	
        return "Should not have gotten here."; 
    }
}
