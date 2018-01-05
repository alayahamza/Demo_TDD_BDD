package com.demo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.config.AppConfig;
import com.demo.model.Account;
import com.demo.model.User;
import com.demo.service.AccountService;
import com.demo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AccountServiceImplTest {

	@Autowired
	AccountService accountService;

	@Autowired
	UserService userService;

	@Test
	public void testAddAccount() {
		User user = new User("hamza", "hamza.alaya@talan.tn");
		int balance = 5000;
		userService.save(user);
		Account account = new Account(balance, user);
		account = accountService.save(account);
		assertNotNull(accountService.findUserAccounts(user.getId()));
	}

	@Test
	public void testMoneyWithdrawFromAccount() {
		User user = new User("hamza", "hamza.alaya@talan.tn");
		int balance = 5000;
		int moneyAmount = 2100;
		userService.save(user);
		Account account = new Account(balance, user);
		account = accountService.save(account);
		account = accountService.withdrawMoneyFromAccount(account.getId(), moneyAmount);
		account = accountService.save(account);
		assertEquals(balance - moneyAmount, account.getBalance());
	}

	@Test
	public void testAddMoneyToAccount() {
		User user = new User("hamza", "hamza.alaya@talan.tn");
		int balance = 5000;
		int moneyAmount = 2100;
		user = userService.save(user);
		Account account = new Account(balance, user);
		account = accountService.save(account);
		account = accountService.addMoneyToAccount(account.getId(), moneyAmount);
		account = accountService.save(account);
		assertEquals(balance + moneyAmount - accountService.getMoneyAddFee(), account.getBalance());
	}

	@Test
	public void testFindAccountById() {
		User user = new User("user", "user@email");
		user = userService.save(user);
		Account account = new Account(200, user);
		account = accountService.save(account); 
		assertNotNull(accountService.findById(account.getId()));

	}

}
