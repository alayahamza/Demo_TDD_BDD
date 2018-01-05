package com.demo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.config.AppConfig;
import com.demo.model.User;
import com.demo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserServiceImplTest {
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImplTest.class);
	@Autowired
	UserService userService;

	@Test
	public void testAddUser() {
		User user = userService.findByName("hamza");
		assertNotNull(user);
		assertEquals("hamza", user.getName());
		assertEquals("hamza.alaya@talan.tn", user.getEmail());
	}

	@Test
	public void testgetUsers() {
		List<User> users = userService.findAll();
		assertNotNull(users);
	}

}
