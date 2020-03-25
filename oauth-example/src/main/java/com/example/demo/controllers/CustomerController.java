package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	
	@Autowired
	private Customer customer;
	
	 @GetMapping("/customer/{userId}")
	    public Customer getCustomerProfile(@PathVariable("userId") String userId) {
	        return getCustomer(userId);
	    }

	    private Customer getCustomer(String userId) {
	       
	        customer.setEmail("admin@abc.com");
	        customer.setFirstName("Ramesh");
	        customer.setLastName("Kumar");
	        customer.setAge(32);
	        customer.setId(userId);
	        return customer;
	    }
}
