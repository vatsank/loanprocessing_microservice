package com.example.demo.domains;

import org.springframework.stereotype.Component;

import com.training.ifaces.Converter;

@Component
public class CurrencyConverter implements Converter {

	@Override
	public double convert(double inr, String type) {
	
		if(type.equalsIgnoreCase("INRTOUSD")) {
		return inr * 65; 
		} else {
			return inr * 55.00;
		}
	}

	
}
