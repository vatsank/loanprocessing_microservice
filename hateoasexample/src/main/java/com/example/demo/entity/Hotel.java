package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "JPHOTEL")
public class Hotel {

    @Id
    private int id;
    private String hotelName;
    private String hotelType;
    private String location;

}
