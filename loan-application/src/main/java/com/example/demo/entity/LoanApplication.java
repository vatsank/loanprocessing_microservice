package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "loan_application")
public class LoanApplication {

	@Id
	private int id;
	private String customerName;
	private long phoneNumber;
	private String panId;
	private double loanAmount;
	private LocalDate applicationDate;
	private String status;
}
