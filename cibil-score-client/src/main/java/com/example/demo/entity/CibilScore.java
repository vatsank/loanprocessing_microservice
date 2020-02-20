package com.example.demo.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CibilScore {

	private String panId;
	private String cardHolderName;
	private long pinCode;
	
	
	
}
