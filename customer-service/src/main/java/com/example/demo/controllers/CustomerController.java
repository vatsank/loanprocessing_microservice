package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {

   
	@Value("${spring.application.name}")
	private String name;
   
	
	
	

    @GetMapping(path = "/message")
	public String getMessage() {
		

		log.info("Request Handled by "+name);
		return "Hello from controller"+name;
	}
    
    

   

    
   
}
