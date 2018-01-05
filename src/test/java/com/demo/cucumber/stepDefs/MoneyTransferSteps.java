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
public class MoneyTransferSteps {

	@Autowired
	AccountService accountService;
	@Autowired
	UserService userService;

	private User firstAccountOwner;
	private User secondAccountOwner;
	private Account toTransferFromAccount;
	private Account toTransferToAccount;
	private int firstAccountBalance;
	private int secondAccountBalance;
	private int transferValue;

	@Given("^account to transfer from initialised with balance '(\\d+)'$")
	public void intialise_account_to_transfer_from(final int balance) {
		firstAccountBalance = balance;
		firstAccountOwner = new User("firstUser", "first@user.email");
		firstAccountOwner = userService.save(firstAccountOwner);
		toTransferFromAccount = new Account(firstAccountBalance, firstAccountOwner);
		toTransferFromAccount = accountService.save(toTransferFromAccount);
	}

	@Given("^account to transfer to initialised with balance '(\\d+)'$")
	public void intialise_account_to_transfer_to(final int balance) {
		secondAccountBalance = balance;
		secondAccountOwner = new User("secondUser", "second@user.email");
		secondAccountOwner = userService.save(secondAccountOwner);
		toTransferToAccount = new Account(secondAccountBalance, secondAccountOwner);
		toTransferToAccount = accountService.save(toTransferToAccount);
	}

	@When("^transfer '(\\d+)' from first account to the second$")
	public void transfer_money_from_an_acount_to_another(final int amountToTransfer) {
		transferValue = amountToTransfer;
		accountService.thirdPartyTransfer(toTransferFromAccount.getId(), toTransferToAccount.getId(), amountToTransfer);
		toTransferFromAccount = accountService.findById(toTransferFromAccount.getId());
		toTransferToAccount = accountService.findById(toTransferToAccount.getId());
	}

	@Then("^take transfer fee '(\\d+)'$")
	public void take_fee_from_account(final int fee) {
		toTransferFromAccount = accountService.withdrawFee(fee, toTransferFromAccount.getId()); 
		assertEquals(firstAccountBalance - transferValue - fee, toTransferFromAccount.getBalance());
		assertEquals(secondAccountBalance + transferValue, toTransferToAccount.getBalance());
	}

}
