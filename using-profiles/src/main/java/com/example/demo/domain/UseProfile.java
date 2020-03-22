package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UseProfile {

	
	@Value("${server.port}")
	private int id;
	@Value("${spring.application.name}")
	private String application;
}
