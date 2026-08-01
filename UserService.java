package com.pooja.dev.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.dev.entity.User;
import com.pooja.dev.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	// method ot save user
	public User saveUser(User usr) {
		System.out.println("User Saving.....");
		User user = new User();
		try {
			user.setName(usr.getName());
			user.setPasswd(usr.getPasswd());
			user.setMobile(usr.getMobile());
			user.setDebitCard(usr.getDebitCard());
			user.setEmail(usr.getEmail());
			user.setCreatedDate(new Date());
			userRepository.save(user);
			System.out.println("User Saved Successfully....");
			return user;
			
		} catch(Exception ex) {
			System.out.println("Error while saving user.....");
			ex.printStackTrace();
			return null;
		}
	}

}
