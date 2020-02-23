package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "JPFOOD")
public class Food {

    @Id
    private int id;
    private String foodName;
    private String cuisine;

}
