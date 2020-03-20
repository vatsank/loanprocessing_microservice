package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	
	@GetMapping(path = "/info")
	public String showMessage() {
		
		return "Hello from Client";
	}
}
