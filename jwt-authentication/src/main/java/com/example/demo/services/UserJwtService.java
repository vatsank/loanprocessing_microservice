package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repos.UserRepository;

@Service
public class UserJwtService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private PasswordEncoder bcrypter;

	
	public UserDetails loadUserByUsername(String username) throws RuntimeException {
		User user = repo.findByUsername(username);
		if (user == null) {
			throw new RuntimeException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(
				                      user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	
	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(this.bcrypter.encode(user.getPassword()));
		return repo.save(newUser);
	}

}
