package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;
@FeignClient("PAST-HISTORY-SERVICE")
@Service
public interface PastHistoryClient {

	@RequestMapping(path = "/api/loan/history/{id}",method = RequestMethod.GET)
	public List<String> getHistory(@PathVariable("id") int id);
}









