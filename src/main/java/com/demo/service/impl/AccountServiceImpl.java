package com.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.AccountDAO;
import com.demo.model.Account;
import com.demo.model.User;
import com.demo.service.AccountService;
import com.demo.service.UserService;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	AccountDAO accountDAO;
	@Autowired
	UserService userService;

	private static final int moneyAddFee = 2;

	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	@Override
	public Account save(Account account) {
		return accountDAO.save(account);
	}

	@Override
	public Account addMoneyToAccount(int accountId, int moneyToAdd) {
		Account account = accountDAO.findById(accountId);
		if (account != null) {
			account.setBalance(account.getBalance() + moneyToAdd - moneyAddFee);
			accountDAO.save(account);
		}
		return account;

	}

	@Override
	public Account withdrawMoneyFromAccount(int accountId, int moneyToWithdraw) {
		Account account = accountDAO.findById(accountId);
		if (account != null) {
			if (account.getBalance() >= moneyToWithdraw) {
				account.setBalance(account.getBalance() - moneyToWithdraw);
				accountDAO.save(account);
			} else {
				LOG.error("Unsufficient Funds !");
			}
		}
		return account;
	}

	@Override
	public Account saveAccount(int ownerId) {
		Account account = null;
		User owner = userService.findById(ownerId);
		if (owner != null) {
			account = new Account();
			account.setOwner(owner);
			accountDAO.save(account);
		}
		return account;
	}

	@Override
	public List<Account> findUserAccounts(int userId) {
		return accountDAO.findByOwnerId(userId);
	}

	@Override
	public Account withdrawFee(int fee, int accountId) {
		Account account = accountDAO.findById(accountId);
		if (account != null) {
			account.setBalance(account.getBalance() - fee);
			accountDAO.save(account);
		}
		return account;
	}

	@Override
	public Account findById(int accountId) {

		return accountDAO.findById(accountId);
	}

	@Override
	public void thirdPartyTransfer(int fromAccountId, int toAccountId, int transferValue) {
		Account fromAccount = accountDAO.findById(fromAccountId);
		Account toAccount = accountDAO.findById(toAccountId);
		if (fromAccount != null) {
			if (toAccount != null) {
				if (fromAccount.getBalance() >= transferValue) {
					fromAccount.setBalance(fromAccount.getBalance() - transferValue);
					toAccount.setBalance(toAccount.getBalance() + transferValue);
					accountDAO.save(fromAccount);
					accountDAO.save(toAccount);
				} else {
					LOG.error("Unsufficient funds !!.");
				}
			} else {
				LOG.error("Account to credit doesn't exist.");
			}
		} else {
			LOG.error("Account to debit doesn't exist.");
		}
	}

	@Override
	public Account withdrawMoneyIfMinBalanceExists(int accountId, int moneyToWithdraw, int minBalance) {
		Account account = accountDAO.findById(accountId);
		if (account != null) {
			if (account.getBalance() >= moneyToWithdraw) {
				if (account.getBalance() >= moneyToWithdraw + minBalance) {
					account.setBalance(account.getBalance() - moneyToWithdraw);
					accountDAO.save(account);
				} else {
					LOG.error("Minimum balance is not respected !");
				}
			} else {
				LOG.error("Unsufficient Funds !");
			}
		}
		return account;
	}

	@Override
	public List<Account> save(List<Account> accounts) {
		return (List<Account>) accountDAO.save(accounts);
	}

	@Override
	public int getMoneyAddFee() {

		return moneyAddFee;
	}

	@Override
	public Account getAccountById(int accountId) {
		return accountDAO.findById(accountId);
	}

}
