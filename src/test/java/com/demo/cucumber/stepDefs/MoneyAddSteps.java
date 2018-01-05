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
public class MoneyAddSteps {

	@Autowired
	AccountService accountService;
	@Autowired
	UserService userService;

	@Given("^My account set with id '(\\d+)' ,blance '(\\d+)'$")
	public void an_account_is_initialiazed_with_id_balance_and_ownerId(final int accountId, final int balance) {
		User user = new User("hamza","hamza.alaya@talan.tn");
		user.setId(1);
		userService.save(user);
		Account account = new Account(accountId, balance, user);
		accountService.save(account);
	}

	@When("^add money '(\\d+)' to acount with id '(\\d+)'$")
	public void withdraw_money_from_account(final int amountToAdd, final int accountId) {
		accountService.addMoneyToAccount(accountId, amountToAdd);
	}

	@Then("^take fee '(\\d+)' from acount with id '(\\d+)' and new balance is '(\\d+)'$")
	public void take_fee_from_account(final int fee, final int accountId, final int newBalance) {
		Account account = accountService.findById(accountId);
		assertEquals(account.getBalance(), newBalance);

	}

}
