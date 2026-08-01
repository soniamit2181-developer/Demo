package com.pooja.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.dev.dto.FoodRequestDTO;
import com.pooja.dev.entity.Food;
import com.pooja.dev.entity.FoodMail;
import com.pooja.dev.entity.User;
import com.pooja.dev.service.DemoComponent;
import com.pooja.dev.service.DemoService;
import com.pooja.dev.service.FoodService;
import com.pooja.dev.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/api")
public class DemoController {
	
	@Autowired
	DemoService demoService;
	
	@Autowired
	DemoComponent demoComponent;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FoodService foodService;
	
	// method to save food
	@PostMapping("/savefd")
	public ResponseEntity<Food> insertFood(@RequestBody Food fd) {
		Food food = demoService.saveFood(fd);
		return new ResponseEntity<Food>(food, HttpStatus.OK);
	}
	
	// get by food type
	@GetMapping("/getbytype/{type}")
	public  ResponseEntity<List<Food>> getByFoodType(@PathVariable("type") String type) {
		List<Food> food = demoService.getByFoodType(type);
		return new ResponseEntity<List<Food>>(food, HttpStatus.OK);
	}
	
	// get message
	@GetMapping("/printmsg") 
	public ResponseEntity<String> printMsg(@RequestParam("msg") String msg) {
		String response = demoComponent.message(msg);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	// update food
	@PutMapping("/updatefd")
	public ResponseEntity<Food> updateFd(@RequestBody Food fd) {
		Food food = demoService.updateFood(fd);
		return new ResponseEntity<Food>(food, HttpStatus.OK);
	}
	
	// save user
	@PostMapping("/saveuser")
	public ResponseEntity<User> insertSave(@Valid @RequestBody User user) {
		User usr = userService.saveUser(user);
		if(usr == null) {
			return new  ResponseEntity<User>(usr, HttpStatus.BAD_REQUEST);
		} 
		return new  ResponseEntity<User>(usr, HttpStatus.OK);
	}
	 
	// method to sort
	@GetMapping("/sortfood")
	public ResponseEntity<List<Food>> sortFood() {
		List<Food> listFd = demoService.sortFoodByName();
		return new ResponseEntity<List<Food>>(listFd, HttpStatus.OK);
	}
	
	// method to call sp
	@GetMapping("/getallfood")
	public ResponseEntity<List<Food>> getFood() {
		List<Food> fd = demoService.getAllFood();
		if(fd == null) {
			return new ResponseEntity<List<Food>>(fd, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Food>>(fd, HttpStatus.OK);
		
	}
	
	// method to call sp by name
		@GetMapping("/getfoodname/{id}")
		public ResponseEntity<String> getFoodName(@PathVariable("id") long fdId) {
			String response  = demoService.getFoodNameById(fdId);
			if(response == null) {
				return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<String>(response, HttpStatus.OK);
			
		}
	
	// method to update food by transaction
		@PatchMapping("/updatefood")
		public ResponseEntity<Food> updateFoodDetails(@RequestBody FoodRequestDTO foodReq) {
			Food fd = foodService.updateFood(foodReq);
			return new ResponseEntity<Food>(fd, HttpStatus.OK);
		}
	
	// methoid to send mail
	@PostMapping("/sendmail")
	public ResponseEntity<String> sendMailController(@RequestBody FoodMail foodMail) {
		String response = foodService.sendMail(foodMail);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	// methoid to send mail with attachments
	@PostMapping("/sendmailwthattach")
	public ResponseEntity<String> sendMailControllerWithAttachments(@RequestBody FoodMail foodMail) {
			String response = foodService.sendMailWithAttachment(foodMail);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
