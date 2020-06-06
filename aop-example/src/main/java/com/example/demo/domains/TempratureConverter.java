package com.example.demo.domains;

import com.training.ifaces.Converter;

public class TempratureConverter implements Converter {

	@Override
	public double convert(double value, String type) {
		
		 if(type.equalsIgnoreCase("CELTOFAR")) {
		return 5/9*(value-32); 
		 } else {
			return 200;
		 }
	}

}
