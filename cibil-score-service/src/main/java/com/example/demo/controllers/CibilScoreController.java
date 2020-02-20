package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.services.CibilScoreService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import com.example.demo.entity.*;
import lombok.Setter;

@RestController
@Setter
@CrossOrigin(origins = "*")
@RefreshScope
public class CibilScoreController {

	@Autowired
	private CibilScoreService service;
	
	
	@GetMapping(path = "/api/v1/cibilscore")
	public List<CibilScore> getAll(){
		
		
		return this.service.findAll();
	}
	
	@PostMapping(produces = "application/json" ,
			consumes = "application/json", path = "/api/v1/cibilscore")
	public CibilScore add(@RequestBody CibilScore entity) {
		
		return this.service.add(entity);
	}
	
	@PutMapping(path = "/api/v1/cibilscore")
	public  CibilScore update(@RequestBody CibilScore entity) {
		return this.service.add(entity);
	}
	
	@Operation(description = "Deletes a Given Entity If not found throws Exception")
	@DeleteMapping(path = "/api/v1/cibilscore")
	public  CibilScore remove(@RequestBody CibilScore entity) {
	
		 CibilScore deletedEntity = this.service.remove(entity);

		 try {
			 

		   if(deletedEntity == null) {
			   
			   throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					   "Requested Entity is Not Found");
		   }
		 } catch(ResponseStatusException execption) {
			 
			 throw execption;
		 }
		 
		 return deletedEntity;
	}
	
	@GetMapping(path ="/api/v1/cibilscore/{panId}" )
	public CibilScore findScoreByPanId(@PathVariable("panId") String panId) {
		
		      return this.service.findScoreByPan(panId);
	}
	
}
