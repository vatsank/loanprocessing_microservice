package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CibilScore;
import com.example.demo.repos.CibilScoreRepository;

import lombok.Setter;

@Service
@Setter
public class CibilScoreService {

	
	@Autowired
	private CibilScoreRepository repo;
	
	
	public List<CibilScore> findAll(){
		
		
		return this.repo.findAll();
		
		
	}
	
	public CibilScore findScoreByPan(String panId) {
		
		return this.repo.findById(panId).get();
		
	}
	public CibilScore  add(CibilScore entity) {
		
		return this.repo.save(entity);
	}
	
	 public CibilScore remove(CibilScore entity) {
		   
		    CibilScore resp = null;
		   
		 if(repo.existsById(entity.getPanId())) {
		    
		    repo.delete(entity);
		    
		    resp= entity;
		    } 
		    
		    return resp;
		   }

}
