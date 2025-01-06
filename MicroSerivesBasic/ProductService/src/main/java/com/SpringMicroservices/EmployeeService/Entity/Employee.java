package com.SpringMicroservices.EmployeeService.Entity;

import com.SpringMicroservices.EmployeeService.Response.AddressReponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="employee")

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="bloodgroup")
	private String bloodgroup;
	
	@Transient
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private AddressReponse addressResponse;
	
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public AddressReponse getAddressResponse() {
		return addressResponse;
	}

	public void setAddressResponse(AddressReponse addressResponse) {
		this.addressResponse = addressResponse;
	}
	
	

}
