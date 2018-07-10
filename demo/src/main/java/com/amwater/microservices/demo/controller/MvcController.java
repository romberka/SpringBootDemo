package com.amwater.microservices.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "Mrs. Doubtfire");
        
        return "thymeleaf";
    }
}
