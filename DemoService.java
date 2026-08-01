package com.pooja.dev.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pooja.dev.entity.Food;
import com.pooja.dev.repository.FoodRepository;

@Service
public class DemoService {
	
	@Autowired
	FoodRepository foodRepository;
	
	// method to save food details
	public Food saveFood(Food fd) {
		System.out.println("Saviing Food...");
		Food food = foodRepository.save(fd);
		return food;
	}
	
	// method to update food by id
	public Food updateFood(Food fd) {
		Food food = null;
		System.out.println("Updating Food..." + fd.getFoodId());
		Optional<Food> optFood = foodRepository.findById(fd.getFoodId());
		if(optFood.isPresent()) {
			food = optFood.get();
			foodRepository.save(fd);
			System.out.println("Food Updated Successfully!!!...");
			return food;
		} else {
			throw new NoSuchElementException("ID not exists..." + food.getFoodId());
		}
		
	}
	
	// method to get food by type
	public List<Food> getByFoodType(String type) {
		System.out.println("Getting Food By Type..." + type);
		List<Food> listFood = foodRepository.findByType(type);
		return listFood;
	}
	
	// method to sort food by name
	public List<Food> sortFoodByName() {
		System.out.println("Sorting By Food Name....");
		List<Food> list5 = foodRepository.findAll(Sort.by("foodName"));
		return list5;
	}
	
	// method to call stored procedure 
	public List<Food> getAllFood() {
		System.out.println("Calling Food Stored Procedure....");
		List<Food> listFd = foodRepository.getFood();
		return listFd;
	}
	
	// method to call SP by ID
	public String getFoodNameById(long id) {
		System.out.println("Getting Food by Stored Procedure...." + id);
		String foodName = "";
		Optional<Food> optFd = foodRepository.findById(id);
		if(optFd.isPresent()) {
			Food fd = optFd.get();
			foodName = fd.getFoodName();
			System.out.println("Food Name=====>" + foodName);
			return foodName;
		} else {
			  throw new NoSuchElementException("Food ID Does Not Exists...." + id);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
