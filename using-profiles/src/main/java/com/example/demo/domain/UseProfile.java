package com.example.demo.domain;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class UseProfile {

	
	@Value("${server.port}")
	private int id;
	@Value("${spring.application.name}")
	private String application;
	
	@Autowired
	private Environment env;

	public void init() {

		log.info("Init Method called");
		log.info(env.getActiveProfiles().toString());
		System.out.println(Arrays.asList(env.getDefaultProfiles().toString()));

		}
}
