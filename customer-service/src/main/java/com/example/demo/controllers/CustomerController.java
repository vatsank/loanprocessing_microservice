package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {

	
    @Value("${server.port}")
	private String port;
    
    @GetMapping(path = "/message")
	public String getMessage() {
		
		log.info("Request Handled by  =======: "+port);
		return "Hello from controller"+port;
	}
}
