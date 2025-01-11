package com.SpringMicroservices.EmployeeService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.SpringMicroservices.EmployeeService.Entity.Employee;
import com.SpringMicroservices.EmployeeService.Response.AddressReponse;
import com.SpringMicroservices.EmployeeService.openFeing.EmployeeFeign;
import com.SpringMicroservices.EmployeeService.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Value("${addressService.base.url}")
	private String baseUrl;
	/*
	 * @Autowired private LoadBalancerClient loadBalancer;
	 */
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeFeign feignService;
	
	@GetMapping("/employees/{id}")
	Employee getEmployeeDetails(@PathVariable("id") int id){
		
		AddressReponse address = new AddressReponse();
		Employee employee=empService.getEmployeeById(id);
		/*
		 * ServiceInstance choose = loadBalancer.choose("EMPLOYEESERVICE");
		 * 
		 * String uri = choose.getUri().toString(); String path =
		 * choose.getMetadata().get("configPath");
		 * 
		 * System.out.println(uri);
		 */
		
		address=feignService.getAddressByEmployeeId(id);
		employee.setAddressResponse(address);
		
		return employee;
		
	}

}
