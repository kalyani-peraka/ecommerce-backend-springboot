package com.alpha.SpringBootDemo1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id 	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int quantity;
	private String catagory;
	private int pricePerUnit;
	private String brandName;
	private String description;
	private String availabilityStatus="available";
	public Product(String name, int quantity, String catagory, int pricePerUnit, String brandName, String description,
			String availabilityStatus) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.catagory = catagory;
		this.pricePerUnit = pricePerUnit;
		this.brandName = brandName;
		this.description = description;
		this.availabilityStatus = availabilityStatus;
	}
	public Product() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public int getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(int pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", catagory=" + catagory
				+ ", pricePerUnit=" + pricePerUnit + ", brandName=" + brandName + ", description=" + description
				+ ", availabilityStatus=" + availabilityStatus + "]";
	}
	
	
}
