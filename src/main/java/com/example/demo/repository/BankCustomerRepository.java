package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BankCustomer;

@Repository
public interface BankCustomerRepository extends JpaRepository<BankCustomer, Long> {
	
	// method to insert using query
	@Modifying
	@Query(
			value = "INSERT INTO bank_cust(account_no, cust_name, email, mobile, address, amount, marital_status, created_date) "
					+ "VALUES(:accno, :custname, :email, :mobile, :addr, :amt, :ms, :createddt)", 
			nativeQuery = true)
	public void insertCust(@Param("accno") String accNo, @Param("custname") String custName, @Param("email") String email, @Param("mobile") long mobile, @Param("addr") String addr, 
						  @Param("amt") double amt, @Param("ms") boolean ms, @Param("createddt") Date createdDate);

}
