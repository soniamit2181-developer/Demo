package com.pooja.dev.dto;

public class FoodRequestDTO {
	
	private long foodId;
	private String foodName;
	private double price;
	private String foodType;
	
	public long getFoodId() {
		return foodId;
	}
	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
	

}
