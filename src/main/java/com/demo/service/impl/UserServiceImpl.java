package com.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDAO;
import com.demo.model.User;
import com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserDAO userDao;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public User findByName(String name) {

		return userDao.findByName(name);
	}

	@Override
	public User saveUser(String name, String email) {
		User user = new User(name, email);
		return userDao.save(user);
	}

	@Override
	public User findById(int ownerId) {
		return userDao.findById(ownerId);
	}

	@Override
	public long usersCount() {
		return userDao.count();
	}

	@Override
	public List<User> save(List<User> users) {
		return (List<User>) userDao.save(users);
	}
	@Override
	public List<String> getUserNames() { 
		return userDao.getUserNames();
	}

	@Override
	public User getUserById(int userId) { 
		return userDao.findById(userId);
	}
}
