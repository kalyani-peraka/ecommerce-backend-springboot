package com.alpha.SpringBootDemo1.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carrier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private long mobileNo;
	private String mailId;
	private int capacity=5;
	 
	@OneToMany
	private List <Orders> olist;

	public Carrier(String name, long mobileNo, String mailId, int capacity, List<Orders> olist) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.mailId = mailId;
		this.capacity = capacity;
		this.olist = olist;
	}

	public Carrier() {
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

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Orders> getOlist() {
		return olist;
	}

	public void setOlist(List<Orders> olist) {
		this.olist = olist;
	}

	@Override
	public String toString() {
		return "Carrier [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", mailId=" + mailId + ", capacity="
				+ capacity + ", olist=" + olist + "]";
	}



	

}
