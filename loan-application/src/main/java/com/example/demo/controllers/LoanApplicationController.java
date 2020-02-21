package com.example.demo.controllers;

import lombok.*;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.clients.CibilScoreClient;
import com.example.demo.clients.PastHistoryClient;
import com.example.demo.entity.CibilScore;
import com.example.demo.entity.LoanApplication;
import com.example.demo.repo.LoanProcessing;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.v3.oas.annotations.Operation;
@RestController
@CrossOrigin("*")
@Setter
public class LoanApplicationController {

	@Autowired
	private  LoanProcessing repoistory;
	
	@Autowired
	private CibilScoreClient scoreClient;
	

	@Autowired
	private PastHistoryClient historyClient;


	@GetMapping(path = "/api/v1/loan/approved")
	public List<LoanApplication> findAllApproved(){
	

		List<LoanApplication> completeList = this.repoistory.findAll();
		
		List<LoanApplication> approvedList =completeList.stream().
				 filter( eachLoan -> eachLoan.getStatus().equalsIgnoreCase("approved")).
				 collect(Collectors.toList());
		
		return approvedList;
	}
	
	
	@GetMapping(path = "/api/v1/loan/pending")
	public List<LoanApplication> findAllPending(){
		
		List<LoanApplication> completeList = this.repoistory.findAll();
		
		List<LoanApplication> pendingList =completeList.stream().
				 filter( eachLoan -> eachLoan.getStatus().equalsIgnoreCase("pending")).
				 collect(Collectors.toList());
		
		return pendingList;
	}

	
	@GetMapping(path = "/api/v1/loan/history/{id}")
	public List<String> fetchHistory(@PathVariable("id") int id){
		
		return this.historyClient.getHistory(id);
	}
	
	
	
	@GetMapping(path = "/api/v1/loan/process")
	@Operation(description = "The Method Invokes another Services and Updates the table ")
	public String process(){
		
		String message ="{message:processed}";
		
		List<LoanApplication> list= repoistory.findAll();
		
		if(list.size()<6) {
			throw new RuntimeException();
		}

		for(LoanApplication eachLoan: list) {
			  CibilScore response = 
					  scoreClient.findScoreByPan(eachLoan.getPanId());
			  
           if(response!=null) {
			  
			if(response.getScore()>300) {
				repoistory.updateStatus(eachLoan.getPanId());
			 }
           }
			
		}   
		
		return message;
	}
	
		
}
