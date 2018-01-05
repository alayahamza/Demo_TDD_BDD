package com.demo.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.demo.Application;
import com.demo.model.User;
import com.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class AccountsControllerTest {

	@Autowired
	UserService userService;
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private RestTemplate restTemplate = new TestRestTemplate();
	private User user;

	@Test
	public void testGetUserById() {
		User userFromApiResponse;
		int userId = 1;
		user = userService.findById(userId);

		userFromApiResponse = restTemplate.getForObject("http://localhost:9999/bank/users/getUserById?userId=" + userId,
				User.class);

		assertEquals(userFromApiResponse, user);
	}

}
