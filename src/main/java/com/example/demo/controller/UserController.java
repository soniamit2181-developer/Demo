package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
@RequestMapping("/v1/animal")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/food")
	public void callAnimal() {
		userService.animalFood();
	}

}
