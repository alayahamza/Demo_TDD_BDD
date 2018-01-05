package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService {

	List<User> findAll();

	User save(User user);
	List<User> save(List<User>users);

	User findByName(String name);

	User saveUser(String name, String email);

	User findById(int ownerId);
	long usersCount();
	List<String> getUserNames();

	User getUserById(int userId);
}
