package com.anubhab.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anubhab.restservices.entities.User;
import com.anubhab.restservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	// Create User
	public User createUser(User user) {
		return userRepo.save(user);
	}

	public Optional<User> getUserById(Long id) {
		Optional<User> user = userRepo.findById(id);
		return user;
	}

	public User updateUser(Long id, User user) {
		user.setId(id);
		return userRepo.save(user);
	}

	public void deleteUserById(Long id) {
		if (userRepo.findById(id).isPresent()) {
			userRepo.deleteById(id);
		}
	}
	
	public User getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}
