package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	// method to save user
	public User saveUser(User us) {
		System.out.println("User Saving....");
		User user = new User();
		user.setUserName(us.getUserName());
		user.setEmail(us.getEmail());
		user.setDept(us.getDept());
		user.setPassword(us.getPassword());
		user.setCreateDate(new Date());
		userRepository.save(user);
		System.out.println("User Saved Successfully....");
		return user;
		
	}

}
