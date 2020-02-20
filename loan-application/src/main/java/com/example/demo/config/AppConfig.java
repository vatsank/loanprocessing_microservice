package com.example.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.CibilScore;

@Configuration
public class AppConfig {

	
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		
		RestTemplate template = new RestTemplate();
		
		template.getInterceptors().add(interceptor());
	    
		return template;
	}
	
	
	
	@Bean
	public BasicAuthenticationInterceptor interceptor() {
	
		 return new BasicAuthenticationInterceptor("india", "india");
	}
	
	
	@Bean
	public CibilScore score() {
		
		return new CibilScore();
	}
}
