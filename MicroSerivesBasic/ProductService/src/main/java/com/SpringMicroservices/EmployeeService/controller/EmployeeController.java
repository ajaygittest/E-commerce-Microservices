package com.SpringMicroservices.EmployeeService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.SpringMicroservices.EmployeeService.Entity.Employee;
import com.SpringMicroservices.EmployeeService.Response.AddressReponse;
import com.SpringMicroservices.EmployeeService.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Value("${addressService.base.url}")
	private String baseUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/employees/{id}")
	Employee getEmployeeDetails(@PathVariable("id") int id){
		
		AddressReponse address = new AddressReponse();
		Employee employee=empService.getEmployeeById(id);
		address=restTemplate.getForObject(this.baseUrl+"/address/{id}", AddressReponse.class,id);
		employee.setAddressResponse(address);
		
		return employee;
		
	}

}
