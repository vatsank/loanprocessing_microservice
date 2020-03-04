package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rest_invoice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

	@Id
	private int id;
	private String customerName;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate invoiceDate;
	@JsonIgnore
	private double amount;
}
