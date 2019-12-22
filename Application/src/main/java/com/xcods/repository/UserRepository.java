package com.xcods.repository;

import org.springframework.data.repository.CrudRepository;

import com.xcods.model.User;

public interface UserRepository extends CrudRepository<User,Integer> {

	public User findByUsernameAndPassword(String username,String password);
}
