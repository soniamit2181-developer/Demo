package com.pooja.dev.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long Id;
	
	@Column(name="name")
	private String name;
	
	@NotBlank(message = "Passwd can't be blank and null...")
	@Column(name="passwd")
	private String passwd;
	
	@Column(name="mobile")
	private String mobile;
	
	@Email(message = "Invalid Email Format....")
	@Column(name="email")
	private String email;
	
	@Transient
	@Column(name="debit_card")
	private String debitCard;
	
	@Column(name="created_date")
	private Date createdDate;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDebitCard() {
		return debitCard;
	}

	public void setDebitCard(String debitCard) {
		this.debitCard = debitCard;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
