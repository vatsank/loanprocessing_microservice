package com.example.demo.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.entity.Invoice;

@RepositoryRestResource()

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	@RestResource(path = "customerNames" ,rel="customerName")
	public Page<Invoice> findByCustomerName(@Param("name") String name,Pageable page);
	
	
	

}
