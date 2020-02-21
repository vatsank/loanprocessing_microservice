package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CibilScore;
import com.example.demo.repo.ScoreRepository;

@RestController
@CrossOrigin(origins = "*")
public class PagingController {

	@Autowired
	private ScoreRepository repo;
	
	@GetMapping(path = "/score/sort/{property}")
	public Iterable<CibilScore> getScoreByOrder(@PathVariable("property") String property){
		
	
		 return repo.findAll(Sort.by(property));
		
	}
	
	@GetMapping(path = "/score/paginate/{page}/{size}/{property}")

	public Iterable<CibilScore> paginate(@PathVariable("page")int page, 
			@PathVariable("size") int size,
			@PathVariable("property") String property){
		
		
		Pageable  pageable = 
				PageRequest.of(page,size,Sort.by(property).ascending ());    
		
		    Page<CibilScore> pages =  this.repo.findAll(pageable);
		
		    
		     if(pages.hasContent()) {
		    	 return pages.getContent();
		     } else {
		    	 
		    	 return new ArrayList<>();
		     }
		
	}
}
