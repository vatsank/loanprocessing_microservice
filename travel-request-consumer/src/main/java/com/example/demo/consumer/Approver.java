package com.example.demo.consumer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import com.example.demo.model.TravelRequest;

import lombok.extern.slf4j.Slf4j;

@EnableBinding(Sink.class)
@Component
@Slf4j
public class Approver {

		
	@StreamListener(target=Sink.INPUT)
	public void receiveRequest(TravelRequest request) throws IOException {
		
		log.info(request.toString());
		System.out.println(request);
		System.out.println("One Request With Details"+ request +"Received");
		
		if(request.getRequestAmount()<5000) {
			request.setStatus("approved");
		}
		PrintWriter out = new PrintWriter(new FileWriter(new File("messages.txt"),true));
		
		out.print(request.toString());
		
		out.close();
		
		 
	}
	
}
