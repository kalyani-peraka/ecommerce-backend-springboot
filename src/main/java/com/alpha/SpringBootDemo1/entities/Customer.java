package com.alpha.SpringBootDemo1.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private long mobileNo;
	private String mail;
	
	@OneToMany
	private List <Address> ladd=new ArrayList<>();;
	
	@OneToMany
	private List <Orders> lorder=new ArrayList<>();;
	
	@OneToMany
	private List <Product> cart=new ArrayList<>();;

	public Customer(String name, long mobileNo, String mail, List<Address> ladd, List<Orders> lorder,
			List<Product> cart) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.mail = mail;
		this.ladd = ladd;
		this.lorder = lorder;
		this.cart = cart;
	}

	public Customer() {
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

	public List<Address> getLadd() {
		return ladd;
	}

	public void setLadd(List<Address> ladd) {
		this.ladd = ladd;
	}

	public List<Orders> getLorder() {
		return lorder;
	}

	public void setLorder(List<Orders> lorder) {
		this.lorder = lorder;
	}

	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", mail=" + mail + ", ladd=" + ladd
				+ ", lorder=" + lorder + ", cart=" + cart + "]";
	}

	
}
