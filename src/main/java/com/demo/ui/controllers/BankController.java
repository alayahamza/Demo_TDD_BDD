package com.demo.ui.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Account;
import com.demo.model.User;
import com.demo.service.AccountService;
import com.demo.service.UserService;

@RestController
@RequestMapping(value = { "/bank" })
public class BankController {
	@Autowired
	UserService userService;
	@Autowired
	AccountService accountService;

	@RequestMapping(method = RequestMethod.GET, value = "accounts/getAccountById")
	@ResponseBody
	public Account getAccountById(@RequestParam("accountId")int accountId) {
		return accountService.getAccountById(accountId);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "users/getUserById")
	@ResponseBody
	public User getUserById(@RequestParam("userId")int userId) {
		return userService.getUserById(userId);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "users/getUserNames")
	@ResponseBody
	public List<String> getUserNames() {
		return userService.getUserNames();
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "accounts/addMoneyToAccount")
	@ResponseBody
	public Account addMoneyToAccount(@RequestParam("accountId") int accountId,
			@RequestParam("moneyToAdd") int moneyToAdd) {

		return accountService.addMoneyToAccount(accountId, moneyToAdd);
	}

	@RequestMapping(method = RequestMethod.POST, value = "accounts/withdrawMoneyFromAccount")
	@ResponseBody
	public Account withdrawMoneyFromAccount(@RequestParam("accountId") int accountId,
			@RequestParam("moneyToWithdraw") int moneyToWithdraw) {

		return accountService.withdrawMoneyFromAccount(accountId, moneyToWithdraw);
	}

	@RequestMapping(method = RequestMethod.GET, value = "accounts/getUserAccounts")
	@ResponseBody
	public List<Account> getUserAccounts(@RequestParam("userId") int userId) {
		return accountService.findUserAccounts(userId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "accounts/addAccount")
	@ResponseBody
	public Account addAccount(@RequestParam("ownerId") int ownerId) {

		return accountService.saveAccount(ownerId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "accounts/getAccounts")
	@ResponseBody
	public List<Account> getAccounts() {
		return accountService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "users/addUser")
	@ResponseBody
	public User addUser(@RequestParam("name") String name, @RequestParam("email") String email) {
		return userService.saveUser(name, email);
	}

	@RequestMapping(method = RequestMethod.GET, value = "users/getUsers")
	@ResponseBody
	public List<User> getUsers() {
		return userService.findAll();
	}
}
