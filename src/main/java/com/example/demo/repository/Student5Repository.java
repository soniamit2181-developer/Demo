package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student5;

@Repository
public interface Student5Repository extends JpaRepository<Student5, Long>{

}
