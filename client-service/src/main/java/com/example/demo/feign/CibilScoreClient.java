package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.CibilScore;

import java.util.*;

@FeignClient("CIBIL-SCORE-SERVICE")
@Service
public interface CibilScoreClient {

	
	     @RequestMapping(path = "/api/v1/cibilscore",
	    		  method = RequestMethod.GET)
	   
	     List<CibilScore> getAll();
}
//private String url = "http://localhost:3030/api/v1/cibilscore";
