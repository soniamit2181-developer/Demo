package com.example.demo.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Animal;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	@Qualifier("deer")
	Animal animal;
	
	// Getting values from properties file
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.services}")
	private String appServices;
	
	
	// method to save user
	public User saveUser(User us) {
		System.out.println("User Saving....");
		System.out.println("App Name===>" + appName);
		System.out.println("App Services===>" + appServices);
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
	
	// method to get user data
	/*public UserDto getUserData(Long id) {
		System.out.println("User Saving...." + id);
		UserDto userDto = null;
		Optional<User> opt = userRepository.findById(id);
		if(opt.isPresent()) {
			User user = opt.get();
			userDto.setUserName(user.getUserName());
			userDto.setEmail(user.getEmail());
			userDto.setDept(user.getDept());
			return userDto;
		})
		return null;
	}*/
	
	// method for animal
	public void animalFood() {
		System.out.println("Calling Animal Food.....");
		animal.food("Grass, Leaves"); 
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
