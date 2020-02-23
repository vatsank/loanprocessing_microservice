package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.client.RestTemplate;

import feign.Request;
import feign.Retryer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@OpenAPIDefinition(info = @Info(title = "Process Loan Applications",
contact =@Contact(email = "admin@abc.com",name = "Ramesh")))

public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

    @Bean
    public static Request.Options requestOptions(ConfigurableEnvironment env) {
    	  return new Request.Options(5000, 30000);
    }

    @Bean
    public Retryer retryer() {
      return new Retryer.Default(1000, 8000, 3);    
    }


}
