package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.example.demo.domain.UseProfile;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class UsingProfilesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(UsingProfilesApplication.class, args);
	
		  UseProfile bean = ctx.getBean(UseProfile.class);
		  
		  log.info(bean.toString());
		  
		  ctx.close();
	}

	@Bean(initMethod = "init")
	@Profile("dev")
	public UseProfile  devProfileBean() {
		
		return new UseProfile();
		
		
	}
	
	@Bean(initMethod = "init")
	@Profile("prod")
	public UseProfile  prodProfileBean() {
		
		return new UseProfile();
		
		
	}
}
