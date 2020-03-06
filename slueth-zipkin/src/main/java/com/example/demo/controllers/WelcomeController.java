package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WelcomeController {

	
	@Autowired
	private BookService service;
	
	@GetMapping(path = "/")
	public String welcome() {
		log.info("welcome method called");
		return "success";
	}
	
	@GetMapping(path="/span")
	public String message() {
		
		log.info("Calling Service");
		
		service.doSomeWorkSameSpan();
		log.info("finished service");
		return "Hello world";
	}
	
	@GetMapping(path="/newSpan")
	public String secondMessage() {
		
		log.info("Calling Service");
		
		service.doSomeOtherWork();
		log.info("finished service");
		return "Hello world";
	}
}
