package com.example.demo.dtos;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDto {

	    private long id;
	    private String username;
	    private String password;


}
