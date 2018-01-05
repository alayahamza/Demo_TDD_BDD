package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "T_USER")
public @Data class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;

	public User() {
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public User(String name) {
		super();
		this.name = name;
	}

}
