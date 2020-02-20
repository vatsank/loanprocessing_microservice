package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.CibilScore;

public class FindCibilScore {

	
	@Autowired
	private RestTemplate template;
	
	private String url = "http://localhost:3030/api/v1/cibilscore";
	
	
	public String getScores() {
		
		String resp = template.getForObject(url, String.class);
		
		return resp;
	}
	
	
	public String addScore(CibilScore score) {
		
	//	CibilScore respAsObject =template.postForObject(url, score, CibilScore.class);
		 
		CibilScore resp = template.postForEntity(url, score, CibilScore.class).getBody();
		
		return resp.toString();
	}
}
