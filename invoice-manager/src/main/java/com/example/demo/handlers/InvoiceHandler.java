package com.example.demo.handlers;

import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.example.demo.entity.Invoice;

import lombok.extern.slf4j.Slf4j;

@RepositoryEventHandler()
@Slf4j
public class InvoiceHandler {

	@HandleBeforeCreate
	public void handleInvoiceSave(Invoice invoice) {
		 
		log.info("Invoice persisited"+invoice.toString());
	}
	
	@HandleAfterCreate
	public void handleInvoiceAfterSave(Invoice invoice) {
		 
		log.info("Invoice persisited"+invoice.toString());
	}
}
