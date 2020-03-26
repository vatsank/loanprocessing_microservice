package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravelRequest {

	
	private long requestId;
	private long employeeId;
	private String employeeName;
	private String employeeBand;
	private double requestAmount;
	private String details;
	private String status;
	
	
}
