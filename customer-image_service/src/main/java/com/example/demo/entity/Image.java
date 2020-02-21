package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="customer_photos")
@NoArgsConstructor
@AllArgsConstructor
public class Image {

	@Id
	private long id;
	private String imageRef;
	private String description;
}
