package com.anubhab.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.anubhab.restservices.entities.User;
import com.anubhab.restservices.exceptions.UserAlreadyExistException;
import com.anubhab.restservices.exceptions.UserNotFoundException;
import com.anubhab.restservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	// Create User
	public User createUser(User user) throws UserAlreadyExistException {
		User userExists = userRepo.findByUsername(user.getUsername());

		if (userExists != null) {
			throw new UserAlreadyExistException("User-Name Already Exists");
		}
		
		userExists = userRepo.findByssn(user.getSsn());
		
		if (userExists != null) {
			throw new UserAlreadyExistException("SSN Already Exists");
		}

		return userRepo.save(user);
	}

	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		return user;
	}

	public User updateUser(Long id, User user) {
		user.setId(id);
		return userRepo.save(user);
	}

	public void deleteUserById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if (!user.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User CANNOT be DELETED.");
		}
		userRepo.deleteById(id);
	}

	public User getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}
