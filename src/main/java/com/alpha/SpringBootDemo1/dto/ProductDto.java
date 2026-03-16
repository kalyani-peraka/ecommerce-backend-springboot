package com.alpha.SpringBootDemo1.dto;

public class ProductDto {
private String name;
private int quantity;
private String catagory;
private int pricePerUnit;
private String brandName;
private String description;
public ProductDto(String name, int quantity, String catagory, int pricePerUnit, String brandName, String description) {
	super();
	this.name = name;
	this.quantity = quantity;
	this.catagory = catagory;
	this.pricePerUnit = pricePerUnit;
	this.brandName = brandName;
	this.description = description;
}
public ProductDto() {
	super();
}
@Override
public String toString() {
	return "ProductDto [name=" + name + ", quantity=" + quantity + ", catagory=" + catagory + ", pricePerUnit="
			+ pricePerUnit + ", brandName=" + brandName + ", description=" + description + "]";
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
}
