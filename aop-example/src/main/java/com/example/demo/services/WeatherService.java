package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domains.City;
import com.example.demo.domains.Weather;

import lombok.Setter;


@Component
@Setter
public class WeatherService {

	@Autowired
	private Weather weather;
	
	
	 		  public Weather getWeather(City city) {
		    System.out.println("Getting Details of City :"
		      + city.getCityName());
		    
		    return weather;
		  }


}
