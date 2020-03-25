package com.example.demo.domains;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Customer {

	 private String firstName;
	    private String lastName;
	    private int age;
	    private String email;
	    private String id;
}
