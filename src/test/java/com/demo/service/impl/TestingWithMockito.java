package com.demo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.demo.model.Account;
import com.demo.model.User;
import com.demo.service.UserService;

public class TestingWithMockito {

	private User user;
	@Mock
	private Account account;

	@Mock
	private UserService userService;

	@Before
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testMockCreation() {
		assertNotNull(account);
		assertNotNull(userService);
		when(userService.usersCount()).thenReturn(new Long(23));
		assertEquals(23, userService.usersCount());
	}

	@Test(expected = NullPointerException.class)
	public void expectNull() {
		user.getEmail();
	}

	 

}
