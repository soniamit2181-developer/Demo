package com.pooja.dev.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long Id;
	
	@Column(name="acc_no", nullable = true, length = 10)
	private String accNo;
	
	@Column(name="acc_name", nullable = true)
	private String accName;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="initial_amt")
	private double initialAmt;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="transaction_date")
	private Date transactionDate;
	
	@Column(name="transaction_id")
	private long transactionId;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getInitialAmt() {
		return initialAmt;
	}

	public void setInitialAmt(double initialAmt) {
		this.initialAmt = initialAmt;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
	
}
