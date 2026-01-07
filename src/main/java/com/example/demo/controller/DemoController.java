package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Company;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Person;
import com.example.demo.entity.Recharge;
import com.example.demo.entity.Student5;
import com.example.demo.entity.User;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.error.InvalidFRecharge;
import com.example.demo.service.DemoService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class DemoController {
	
	@Autowired
	DemoService demoService;
	
	@Autowired
	UserService userService;
	
	// Method to post
	@PostMapping("/savePerson")
	public void insertPerson(@RequestBody Person person) {
		System.out.println("Inside insertPerson....");
		demoService.savePerson(person);
	}
	
	// Method to save company address
	@PostMapping("/compaddr")
	public ResponseEntity<Company> insertCompAddress(@RequestBody Company comp) {
		System.out.println("Inside insertCompAddress....");
		Company company = demoService.saveCompanyAddress(comp);
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}
	
	// Method to save orders
	@PostMapping("/saveorders")
	public ResponseEntity<String> insertOrderDetails() {
		System.out.println("Inside insertOrderDetails....");
		String response = demoService.saveOrdersDetails();
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	// Method to save student
	@PostMapping("/savestudent")
	public ResponseEntity<List<Student5>> insertStudentDetls(@RequestBody Student5 student) {
		System.out.println("Inside insertStudentDetls....");
		List<Student5> listDetls = demoService.saveStudentDetails(student);
		return new ResponseEntity<List<Student5>>(listDetls, HttpStatus.OK);
	}
	
	// Method to save Student - Course
	@PostMapping("/savestucourse")
	public ResponseEntity<String> insertStudentCourses() {
		System.out.println("Inside insertStudentCourses....");
		String response = demoService.saveStudentCourseDetls();
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	// Method to get customer name
	@GetMapping("/getcrname/{nm}")
	public ResponseEntity<Customer> getCustDets(@PathVariable("nm") String nm) {
		System.out.println("Inside getCustDets...."); 
		Customer c5 = null;
		try {
			c5 = demoService.retreiveCustomerName(nm);
		} catch (CustomerNotFoundException e) {
			System.out.println("Error while getting customer in controller....");
			e.printStackTrace();
		}
		return new ResponseEntity<Customer>(c5, HttpStatus.OK);
	}
	
	// Method to save recharge
	@PostMapping("/saverecharge")
	public ResponseEntity<Recharge> insertRecharge(@RequestBody Recharge recharge) {
		System.out.println("Inside insertStudentCourses....");
		Recharge rec = demoService.saveRecharge(recharge);
		return new ResponseEntity<Recharge>(rec, HttpStatus.OK);
	}
	
	// method to get operator
	@GetMapping("/getoperator/{opr}")
	public ResponseEntity<List<Recharge>> getOperator(@PathVariable("opr") String opr) {
		System.out.println("Inside getOperator....");
		List<Recharge> list5 = demoService.getCustDetails(opr);
		return new ResponseEntity<List<Recharge>>(list5, HttpStatus.OK);
	}
	
	// method by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Recharge> getRechargeById(@PathVariable("id") long id) throws InvalidFRecharge {
		Recharge rec = demoService.getDetailsById(id);
		return new ResponseEntity<Recharge>(rec, HttpStatus.OK); 
	}
	
	// methpd to save user
	@PostMapping("/saveuser")
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		User usr = userService.saveUser(user);
		return new ResponseEntity<User>(usr, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
