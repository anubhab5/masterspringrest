package com.anubhab.restservices.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.anubhab.restservices.entities.User;
import com.anubhab.restservices.exceptions.UserAlreadyExistException;
import com.anubhab.restservices.exceptions.UserNameNotFoundException;
import com.anubhab.restservices.exceptions.UserNotFoundException;
import com.anubhab.restservices.services.UserService;

@RestController
@Validated
public class UsercController {

	@Autowired
	private UserService userSvc;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userSvc.getAllUser();
	}

	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			return userSvc.getUserById(id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PostMapping("/users")
	public User saveUser(@RequestBody @Valid User user) {
		try {
			return userSvc.createUser(user);
		} catch (UserAlreadyExistException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
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
	public User getUserByUsername(@PathVariable("username") String username) throws UserNameNotFoundException {
		User user = userSvc.getUserByUsername(username);
		if (user == null) {
			throw new UserNameNotFoundException("User " + username + " does not Exist");
		}
		return userSvc.getUserByUsername(username);
	}
}
