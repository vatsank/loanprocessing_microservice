package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Image;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CustomerImageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerImageServiceApplication.class, args);
	}

	@Bean
	public Image defaultImage() {
		
		
		return new Image(000,"custLogo","Default Customer Logo");
	}
}








