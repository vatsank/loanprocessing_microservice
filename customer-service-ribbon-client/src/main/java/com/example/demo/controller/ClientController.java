package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	
	@Autowired
	private RestTemplate template;

	LoadBalancerClient client;
	
	@GetMapping(path = "/customer")
	public String fetchData() {

		return template.getForObject("http://customer-service/message", String.class);
	}

	
	@Autowired
   private LoadBalancerClient loadBalancer;

      @GetMapping(path="/cust")
        public String greeting() {
		ServiceInstance instance = loadBalancer.choose("customer-service");
		URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));

		System.out.println("============="+ storesUri);
		return template.getForObject(storesUri+"/customer-service/message", String.class);
	}
}
