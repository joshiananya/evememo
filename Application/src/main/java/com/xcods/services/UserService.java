package com.xcods.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcods.model.User;
import com.xcods.repository.UserRepository;

@Service
@Transactional
public class UserService  {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}
	
	public  void saveMyUser(User user)
	{
		userRepository.save(user);
	}
	public List<User> showAllUsers()
	{
		List<User> users=new ArrayList<User>();
		for(User user:userRepository.findAll())
		{
			users.add(user);
		}
		return users;
	}
	public void deleteMyUser(int id)
	{
		userRepository.deleteById(id);
	}

	public Optional<User> editMyUser(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
	public User findByUsernameAndPassword(String username,String password)
	{
		return userRepository.findByUsernameAndPassword(username, password);
	}

}
