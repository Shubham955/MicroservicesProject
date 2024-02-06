package com.nagarro.customer.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class CustomerDetail {
	@Id
	String customerId;
	String name;
	long phoneNumber;
	String address;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	Date creationTime;
	
	@PrePersist
	private void onCreate() {
		creationTime=new Date();
	}

	public CustomerDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDetail(String customerId, String name, long l, String address, Date creationTime) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phoneNumber = l;
		this.address = address;
		this.creationTime = creationTime;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "CustomerDetail [customerId=" + customerId + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", creationTime=" + creationTime + "]";
	}
}
