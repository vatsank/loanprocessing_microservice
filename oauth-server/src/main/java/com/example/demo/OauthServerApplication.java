package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class OauthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthServerApplication.class, args);
	}

	 
}

//https://dzone.com/articles/build-an-oauth-20-authorization-server-with-spring
// http://localhost:4040/oauth/token
//http://www.programmersought.com/article/5278639585/
//
//
//[008] How to Secure Micro services - oAuth2 Server part 01 - [Micro services in and out 008]