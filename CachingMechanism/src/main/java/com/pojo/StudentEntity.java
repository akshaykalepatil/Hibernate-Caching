package com.pojo;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GeneratorType;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

@Entity
@Table(name = "StudInfo")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class StudentEntity {

	@Id
	@Column(name = "Stud_Rollno")
	int id;
	@Column(name = "Stud_name")
	String name;

	@OneToOne(cascade = { CascadeType.ALL })
	Address address;

	public StudentEntity() {
		super();
	}

	public StudentEntity(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", address=" + address + "]";
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
