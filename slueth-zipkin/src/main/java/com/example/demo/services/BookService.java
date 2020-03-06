package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brave.Span;
import brave.Tracer;
import brave.Tracer.SpanInScope;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {


	@Autowired
	private Tracer tracer;
	
    public void doSomeWorkSameSpan() {
        try {
            log.info("Doing some work");

			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public void doSomeOtherWork() {
    	
    	 log.info("I'm in the original span");
    	 
    	    Span newSpan = tracer.nextSpan().name("newSpan").start();
    	    try (SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
    	        try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	        log.info("I'm in the new span doing some cool work that needs its own span");
    	    } finally {
    	        newSpan.finish();
    	    }
    	 
    	    log.info("I'm in the original span");
    	}
    }

