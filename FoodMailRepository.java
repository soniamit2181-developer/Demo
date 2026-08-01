package com.pooja.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pooja.dev.entity.FoodMail;

@Repository
public interface FoodMailRepository extends JpaRepository<FoodMail, Long> {

}
