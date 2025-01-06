package com.SpringMicroservices.AddressService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringMicroservices.AddressService.Entity.Address;
import com.SpringMicroservices.AddressService.Repository.AddressRepo;

@Service
public class AddressService {

	@Autowired
	private AddressRepo repo;
	
	
	
	public Address addressDetails(int employeeId) {
		
		Address findAddressByEmployeeId= repo.findAddressByEmployeeId(employeeId);
		
		return findAddressByEmployeeId;
		
	}
}
