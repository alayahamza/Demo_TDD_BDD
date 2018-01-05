package com.demo.cucumber.stepDefs;

import static org.junit.Assert.assertTrue;

import java.util.List;

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
public class MinBalanceValidationSteps {

	@Autowired
	AccountService accountService;
	@Autowired
	UserService userService;

	private List<User> usersList;
	private List<Account> accountsList;
	private int minimumBalance;

	@Given("^a list of users$")
	public void initialize_users_list(final List<User> users) {
		usersList = users;
		usersList = userService.save(usersList);
	}

	@Given("^a list of users accounts$")
	public void initialize_accounts_list(final List<Account> accounts) {
		accountsList = accounts;
		int usersCounter = 0;
		for (Account account : accountsList) {
			account.setOwner(usersList.get(usersCounter));
			usersCounter++;
		}
		accountService.save(accountsList);
	}

	@When("^withdraw money amount '(\\d+)' from users accounts if minimum balance is '(\\d+)'$")
	public void withdraw_money_from_account_if_having_min_balance(final int amountToWithdraw, final int minBalance) {
		minimumBalance = minBalance;
		for (Account account : accountsList) {
			accountService.withdrawMoneyIfMinBalanceExists(account.getId(), amountToWithdraw, minimumBalance);
		}
		accountsList = accountService.findAll();
	}

	@Then("^all accounts should have minimum balance$")
	public void validate_accounts_for_min_balance() {
		for (Account account : accountsList) {
			assertTrue(account.getBalance() >= minimumBalance);
		}
	}
}
