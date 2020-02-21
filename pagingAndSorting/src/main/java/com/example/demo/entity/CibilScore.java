package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "syn_cibil_score")
public class CibilScore {

	@Id
	private String panId;
	private String cardHolderName;
	private long pinCode;
	private double score;
	
	
	
}
