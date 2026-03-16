package com.alpha.SpringBootDemo1.dto;


public class AdminDto {
private String name;
private long mobNo;
private String mail;
public AdminDto() {
	super();
}
public AdminDto(String name, long mobNo, String mail) {
	super();
	this.name = name;
	this.mobNo = mobNo;
	this.mail = mail;
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
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
@Override
public String toString() {
	return "AdminDto [name=" + name + ", mobNo=" + mobNo + ", mail=" + mail + "]";
}
}

