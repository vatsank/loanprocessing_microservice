package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class SecurityConfig {

	/**
	 * Request Interceptor and BasicAuthRequestInterceptor are from Feign API
	 * They are not from spring API - REST template uses Interceptor from spring API
	 * @return
	 */
    @Bean
   public RequestInterceptor basicAuthRequestInterceptor() {
       return new BasicAuthRequestInterceptor ("india", "india"); 
    }
}
