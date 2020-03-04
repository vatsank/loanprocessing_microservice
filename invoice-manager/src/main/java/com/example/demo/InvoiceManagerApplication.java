package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Invoice;
import com.example.demo.handlers.InvoiceHandler;
import com.example.demo.repo.InvoiceRepository;

@SpringBootApplication
public class InvoiceManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceManagerApplication.class, args);
	}

	@Bean
	public InvoiceHandler handler() {
		
		return new InvoiceHandler();
	}
	
	@Bean
	public CommandLineRunner runner(InvoiceRepository repo) {
		
		return (args) ->{
			
			repo.save(new Invoice(110,"Ramesh",LocalDate.of(2020, 1,27),4500));
			repo.save(new Invoice(119,"Ganesh",LocalDate.of(2019, 4,17),3500));

		};
		
	}
}

