package com.alpha.SpringBootDemo1.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private long mobileNo;
	private String mail;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List <Address> alist=new ArrayList<>();

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", mail=" + mail + ", alist=" + alist
				+ "]";
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Address> getAlist() {
		return alist;
	}

	public void setAlist(List<Address> alist) {
		this.alist = alist;
	}

	public Admin(String name, long mobileNo, String mail, List<Address> alist) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.mail = mail;
		this.alist = alist;
	}

	public List<Address> getLadd() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}