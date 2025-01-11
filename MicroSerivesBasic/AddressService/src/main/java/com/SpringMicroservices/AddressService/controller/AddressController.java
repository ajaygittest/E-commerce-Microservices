package com.SpringMicroservices.AddressService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.SpringMicroservices.AddressService.Entity.Address;
import com.SpringMicroservices.AddressService.Service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<Address> getAddressByEmployeeId(@PathVariable("employeeId") int id) {
		 
		System.out.println("Address Services");
		Address address=service.addressDetails(id);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(address);
		
	}

}
