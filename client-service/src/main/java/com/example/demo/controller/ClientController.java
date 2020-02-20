package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CibilScore;
import com.example.demo.feign.CibilScoreClient;

@RestController
@CrossOrigin(origins = "*")
public class ClientController {

	
	@Autowired
	private CibilScoreClient clientService;
	
	
	@GetMapping(path = "/scores")
	public List<CibilScore> getScores(){
		
		return this.clientService.getAll();
	}
}
