package com.example.demo.dto;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dog")

public class Dog implements Animal {
	
	@Override
	public void food(String type) {
		System.out.println("Calling Dog.....");
		System.out.println("Dog eats " + type);
	}

}
