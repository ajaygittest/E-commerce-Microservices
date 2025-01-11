package com.SpringMicroservices.EmployeeService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.SpringMicroservices.EmployeeService.Entity.Employee;
import com.SpringMicroservices.EmployeeService.Repository.EmployeeRespository;

@Service
public class EmployeeService {
	
	@Autowired  
	private EmployeeRespository employeeRepo;

	
	public Employee getEmployeeById(int id) {
		
		
		Employee employee=employeeRepo.findById(id).get();
		
		return employee;
	}

}
