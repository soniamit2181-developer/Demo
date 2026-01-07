package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Aadhaar;

@Repository
public interface AadhaarRepository extends JpaRepository<Aadhaar, Long> {

}
