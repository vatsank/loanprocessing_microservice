package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Image;
import com.example.demo.repo.ImageRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class ImageController {

	@Autowired
	private ImageRepository repo;

	@Autowired
	private Image defaultImage;

	@GetMapping(path = "/api/v1/images/{id}")
	
	@HystrixCommand(fallbackMethod = "fallBackMethodforFindById")
	
	public Image findById(@PathVariable("id") long id) {
		
		Image image = null;
		
		Optional<Image> response = this.repo.findById(id);
		
		 if(response.isPresent()) {
			 
			 image = response.get();
			 log.info("Image found");
		 } else {
			 log.debug("Image not found Exeception thrown");
			 throw new RuntimeException();
			 
		 }
		 
		 return image;
	}
	
	public Image fallBackMethodforFindById(long  id) {
		log.info("Fall back method executed");
		return this.defaultImage;
	}
}
