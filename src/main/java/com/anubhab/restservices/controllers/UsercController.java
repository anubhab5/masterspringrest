package com.anubhab.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anubhab.restservices.entities.User;
import com.anubhab.restservices.services.UserService;

@RestController
public class UsercController {

	@Autowired
	private UserService userSvc;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userSvc.getAllUser();
	}

	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id) {
		return userSvc.getUserById(id);
	}

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userSvc.createUser(user);
	}

	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		return userSvc.updateUser(id, user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userSvc.deleteUserById(id);
	}
	
	@GetMapping("users/byuser/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return userSvc.getUserByUsername(username);
	}
	
	

}
