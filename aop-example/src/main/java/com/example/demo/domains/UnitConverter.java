package com.example.demo.domains;

import org.springframework.stereotype.Component;

@Component
public class UnitConverter {

	
	public double convert(double mtr, String type) {
		
		if(type.equalsIgnoreCase("MTRTOKMS")) {
		return mtr * 100; 
		} else {
			return mtr / 100.00;
		}
	}
}
