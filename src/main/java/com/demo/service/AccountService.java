package com.demo.service;

import java.util.List;

import com.demo.model.Account;

public interface AccountService {

	List<Account> findAll();

	Account save(Account account);

	Account addMoneyToAccount(int accountId, int moneyToAdd);

	Account withdrawMoneyFromAccount(int accountId, int moneyToWithdraw);

	Account withdrawMoneyIfMinBalanceExists(int accountId, int moneyToWithdraw, int minBalance);

	Account saveAccount(int ownerId);

	List<Account> findUserAccounts(int userId);

	Account withdrawFee(int fee, int accountId);

	Account findById(int accountId);

	void thirdPartyTransfer(int fromAccountId, int toAccountId, int transferValue);

	List<?> save(List<Account> accounts);

	int getMoneyAddFee();

	Account getAccountById(int accountId);
	

	
}
