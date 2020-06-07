package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.demo.domains.City;
import com.example.demo.domains.CurrencyConverter;
import com.example.demo.domains.UnitConverter;
import com.example.demo.domains.Weather;
import com.example.demo.services.TranslateService;
import com.example.demo.services.WeatherService;
import com.training.ifaces.Converter;

@SpringBootApplication
public class AopExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(AopExampleApplication.class, args);
	
	TranslateService service =	ctx.getBean(TranslateService.class);
	
	System.out.println(service.translate("rice", "eng", "hin"));
	
	Converter conv = ctx.getBean(CurrencyConverter.class);
	
	System.out.println(conv.convert(200, "INRTOUSD"));
	
	
	UnitConverter conv2 = ctx.getBean(UnitConverter.class);
	
System.out.println(conv2.convert(100, "MTRTOKMS"));

WeatherService account = ctx.getBean(WeatherService.class);

City chn = ctx.getBean(City.class);

 account.getWeather(chn);
	ctx.close();
	}

	@Bean
	public City chennai() {
		
		return new City(1200,"Chennai","India");
	}
	
	@Bean
	public Weather chennaiWeather() {
		
		return new Weather("Chennai", "36/30", "65%", "km/h");
	}
	
}
