package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BankCustomer;
import com.example.demo.service.BankCustomerService;

@RestController
@RequestMapping("/v1/bank")
public class BankCustomerController {
	
	@Autowired
	BankCustomerService bankCustomerService;
	
	// method to save bank customer
	@PostMapping("/savecust")
	public void insertBankCustomer(@RequestBody BankCustomer BankCustomer) {
		System.out.println("Inside insertBankCustomer....");
		bankCustomerService.saveBankCustomer(BankCustomer);
	}
	
	// method to save cust
	@PostMapping("/savecust5")
	public ResponseEntity<BankCustomer> insertCustomer(@RequestBody BankCustomer cust) {
		System.out.println("Inside insertCustomer....");
		BankCustomer customer = bankCustomerService.saveCustomer(cust);
		return new ResponseEntity<BankCustomer>(customer, HttpStatus.OK);
	}

}
