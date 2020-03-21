package com.example.demo.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	 private String firstName;
	    private String lastName;
	    private int age;
	    private String email;
	    private String id;
}
