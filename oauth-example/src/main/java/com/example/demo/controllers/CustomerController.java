package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	 @GetMapping("/customer/{userId}")
	    public Customer getCustomerProfile(@PathVariable("userId") String userId) {
	        return getCustomer(userId);
	    }

	    private Customer getCustomer(final String userId) {
	        Customer customer = new Customer();
	        customer.setEmail("contact-us@javadevjournal.com");
	        customer.setFirstName("Demo");
	        customer.setLastName("User");
	        customer.setAge(21);
	        customer.setId(userId);
	        return customer;
	    }
}
