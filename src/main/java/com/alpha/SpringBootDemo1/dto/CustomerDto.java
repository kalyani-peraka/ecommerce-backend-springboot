package com.alpha.SpringBootDemo1.dto;

import com.alpha.SpringBootDemo1.entities.Address;

public class CustomerDto {
		private String name;
		private long mobileNo;
		private String mail;
		private Address address;
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
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public CustomerDto(String name, long mobileNo, String mail, Address address) {
			super();
			this.name = name;
			this.mobileNo = mobileNo;
			this.mail = mail;
			this.address = address;
		}
		public CustomerDto() {
			super();
		}
		@Override
		public String toString() {
			return "CustomerDto [name=" + name + ", mobileNo=" + mobileNo + ", mail=" + mail + ", address=" + address + "]";
		}
		
	}
