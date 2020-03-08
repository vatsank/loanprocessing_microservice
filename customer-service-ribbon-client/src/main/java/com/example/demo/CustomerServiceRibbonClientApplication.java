package com.example.demo;

import org.ribbon.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name = "customer-service",configuration = RibbonConfig.class)
public class CustomerServiceRibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceRibbonClientApplication.class, args);
	}

	 @Bean
	 @LoadBalanced
	 public RestTemplate template() {
		 
		 return new RestTemplate();
	 }
}
