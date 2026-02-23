package com.example.demo.dto;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("deer")
@Primary
public class Deer implements Animal {
	
	@Override
	public void food(String type) {
		System.out.println("Calling Deer.....");
		System.out.println("Deer eats " + type);
	}

}
