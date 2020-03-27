package com.example.demo;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.Message;

@RestController
public class ProducerController {

	 private MessageChannel greet;

	    public ProducerController(HelloBinding binding) {
	        greet = binding.greeting();
	    }

	    @GetMapping("/greet/{name}")
	    public void publish(@PathVariable String name) {
	        String greeting = "How are you Mr, " + name + "!";
	        Message<String> msg = MessageBuilder.withPayload(greeting).build();
	        this.greet.send(msg);
	    }
}
