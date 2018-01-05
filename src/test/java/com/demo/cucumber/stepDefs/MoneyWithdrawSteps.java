package com.demo.cucumber.stepDefs;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.demo.config.CucumberConfiguration;
import com.demo.model.Account;
import com.demo.model.User;
import com.demo.service.AccountService;
import com.demo.service.UserService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = { CucumberConfiguration.class })
public class MoneyWithdrawSteps {

	@Autowired
	AccountService accountService;
	@Autowired
	UserService userService;

	Account account;
	@Given("^user account initialized with id '(\\d+)' , blance '(\\d+)'$")
	public void user_account_is_initialiazed_with_id_balance_and_ownerId(final int accountId, final int balance) {
		User user = new User("hamza", "hamza.alaya@talan.tn");
		user.setId(1);
		userService.save(user);
		account = new Account(balance, user);
		accountService.save(account);
	}

	@When("^withdraw money amount '(\\d+)' from acount with id '(\\d+)'$")
	public void withdraw_money_from_account(final int amountToAdd, final int accountId) {
		account = accountService.withdrawMoneyFromAccount(accountId, amountToAdd);
	}

	@Then("^validate acount with id '(\\d+)'  new balance is '(\\d+)'$")
	public void validate_balance_after_withdraw(final int accountId, final int newBalance) {
		 account = accountService.findById(accountId);
		assertEquals(account.getBalance(), newBalance);

	}
}
