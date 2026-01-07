package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="recharge")
public class Recharge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="mobile", nullable=false)
	private String mobile;
	
	@Column(name="cust_name")
	private String custName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="operator")
	private String operator;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="recharge_date")
	private LocalDate rechargeDate;
	
	@Column(name="recharge_valid_date")
	private LocalDate rechargeValidDate;
	
	@Column(name="no_days")
	private int noDays;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	@Column(name="transaction_id")
	private long transactionId;
	
	@Column(name="remarks")
	private String remarks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getRechargeDate() {
		return rechargeDate;
	}

	public void setRechargeDate(LocalDate rechargeDate) {
		this.rechargeDate = rechargeDate;
	}

	public LocalDate getRechargeValidDate() {
		return rechargeValidDate;
	}

	public void setRechargeValidDate(LocalDate rechargeValidDate) {
		this.rechargeValidDate = rechargeValidDate;
	}

	public int getNoDays() {
		return noDays;
	}

	public void setNoDays(int noDays) {
		this.noDays = noDays;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
