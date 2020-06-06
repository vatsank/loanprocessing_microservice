package com.example.demo.services;


import org.springframework.stereotype.Component;

import com.example.demo.domains.City;


@Component
public class WeatherService {

	 		  public void updateAccountDescription(City city) {
		    System.out.println("Getting Details of City :"
		      + city.getCityName());
		  }


}
