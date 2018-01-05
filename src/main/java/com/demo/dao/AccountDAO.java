package com.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Serializable> {

	Account findById(int id);

	List<Account> findByOwnerId(int userId);
	
	
}
