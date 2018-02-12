package com.pojo;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Stud_Add")
@Cacheable 
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Address {
	@Id
	@Column(name = "pin")
	int pincode;
	@Column(name = "city")
	String city;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int pincode, String city) {
		super();
		this.pincode = pincode;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [pincode=" + pincode + ", city=" + city + "]";
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
