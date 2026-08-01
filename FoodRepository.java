package com.pooja.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pooja.dev.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository <Food, Long> {
	
	// Method to get food by food type ----- JPQL
	@Query("SELECT fd from Food fd where fd.foodType=:type")
	List<Food> findByType(@Param("type") String type);
	
	// Method to call stored procedure 
	@Query(value = "CALL GetFood()", nativeQuery = true)
	List<Food> getFood();
	
	// Method to cal  SP by food id
	@Query(value = "CALL GetFoodByID(:id)", nativeQuery = true)
	String getFoodName(@Param("id") long id);
	
	// Method to call food name by type
	@Procedure(procedureName = "GetFoodByType")
	String getFoodNameByType(@Param("type") String type);
	

}
