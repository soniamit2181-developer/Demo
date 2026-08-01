package com.pooja.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.dev.entity.Account;
import com.pooja.dev.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	// method for deposit transaction
	public void deposit() {
		boolean result = false;
		System.out.println("Depositing Money.....");
		// Account A details
		Account A = new Account();
		A.setAccNo("1289556610");
		A.setAccName("Amit");
		A.setBankName("HDFC");
		A.setInitialAmt(2000.00);
		// Account P details
		Account P = new Account();
		A.setAccNo("7789015665");
		A.setAccName("Pooja");
		A.setBankName("HDFC");
		A.setInitialAmt(4000.00);
		
		

	}
	// method to transfer money
	public boolean transferMoney(Account debit, Account credit, double amtDebit, double amtCredit) {
		System.out.println("Transferring Money.....");
		double debitBal = 0.0, creditBal = 0.0;
		boolean status = false;
		try {
			debitBal = debit.getInitialAmt();
			creditBal = credit.getInitialAmt();
			System.out.println("Transferring Money" + " to " + debit.getAccName() + " from " + credit.getAccName());
			creditBal = creditBal + amtCredit;
			debitBal = debitBal - amtDebit;
			System.out.println("Credited------>" + creditBal + " " + "Debited----->" + debitBal);
			status = true;
			return status;
			
		} catch(Exception ex) {
			System.out.println("Exception while transferring money.....");
			ex.printStackTrace();
			return status;
		}
	}
	
	
}
