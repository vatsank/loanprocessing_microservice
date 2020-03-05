package com.example.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.CibilScore;
import feign.Logger;
import feign.Request;
import feign.Retryer;
@Configuration
public class AppConfig {

	@Bean
	  public RestTemplate rest() {
		  		  return new RestTemplate();
	  } 
	
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
	
	  @Bean
	  public Logger.Level configureLogLevel(){
	    return  Logger.Level.FULL;
	  }
	  
//	  @Bean 
//	  public Request.Options timeoutConfiguration(){
//	    
//	    return new Request.Options(5000, 30000);
//	  }
	  
//	  @Bean
//	  public Retryer retryer() {
//	    
//	    return new Retryer.Default(1000, 8000, 3);		
//	  }
}
