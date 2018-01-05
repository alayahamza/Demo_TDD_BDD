package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name = "T_ACCOUNT")

public @Data class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int balance;
	@JoinColumn(name = "OWNER_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private User owner;

	public Account() {
	}

	public Account(int balance, User owner) {
		super();
		this.balance = balance;
		this.owner = owner;
	}

	public Account(int id, int balance, User owner) {
		super();
		this.id = id;
		this.balance = balance;
		this.owner = owner;
	}

}
