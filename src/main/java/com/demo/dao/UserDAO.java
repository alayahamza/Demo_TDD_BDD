package com.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Serializable> {

	User findByName(String name);

	User findById(int ownerId);
	
	@Query("select name from T_USER")
	List<String> getUserNames(); 
}
