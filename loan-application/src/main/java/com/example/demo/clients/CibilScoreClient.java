package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Service;
import com.example.demo.entity.CibilScore;

@FeignClient("CIBIL-SCORE-SERVICE")
@Service
public interface CibilScoreClient {

	@RequestMapping(path = "/api/v1/cibilscore/{panId}",method = RequestMethod.GET)
	public CibilScore findScoreByPan(@PathVariable("panId") String pan);
	
}
