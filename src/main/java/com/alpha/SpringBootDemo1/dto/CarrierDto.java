package com.alpha.SpringBootDemo1.dto;

public class CarrierDto {
private String name;
private long mobNo;
private String mailId;
@Override
public String toString() {
	return "CarrierDto [name=" + name + ", mobNo=" + mobNo + ", mailId=" + mailId + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getMobNo() {
	return mobNo;
}
public void setMobNo(long mobNo) {
	this.mobNo = mobNo;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}
public CarrierDto() {
	super();
}
public CarrierDto(String name, long
		mobNo, String mailId) {
	super();
	this.name = name;
	this.mobNo = mobNo;
	this.mailId = mailId;
}
}
