package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BankCustomer;
import com.example.demo.repository.BankCustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class BankCustomerService {
	
	@Autowired
	BankCustomerRepository bankCustomerRepository;
	
	// method to save bank customer
	@Transactional
	public void saveBankCustomer(BankCustomer cust) {
		System.out.println("Saving Bank Customer....");
		System.out.println("acc no====" + cust.getAccountNo() + "  " + "acc name====" + cust.getCustName());
		//bankCustomerRepository.insertCust(cust.getAccountNo(), cust.getCustName(), cust.getEmail(), cust.getMobile(), 
		//								  cust.getAddress(), cust.getAmount(), cust.isMaritalStatus(), new Date());
		
		System.out.println("Bank Customer Successfully Saved....");
	}
	
	// method to save bank cust
	@Transactional
	public BankCustomer saveCustomer(BankCustomer cust) {
		System.out.println("Saving Customer....");
		BankCustomer customer = new BankCustomer();
		try {
			customer.setAccountNo(cust.getAccountNo());
			customer.setMobile(cust.getMobile());
			customer.setEmail(cust.getEmail());
			customer.setAddress(cust.getAddress());
			customer.setAmount(cust.getAmount());
			customer.setCustName(cust.getCustName());
			customer.setCreatedDate(new Date());
			bankCustomerRepository.save(customer);
			System.out.println("Customer Saved Successfully....");
		} catch(Exception ex) {
			System.out.println("Error while saving customer....");
			ex.printStackTrace();
		}
		return customer;
	}

}
