package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jwtuser")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
    private long id;
    private String username;
    @JsonIgnore
    private String password;

}
