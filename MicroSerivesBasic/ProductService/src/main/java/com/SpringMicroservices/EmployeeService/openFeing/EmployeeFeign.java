package com.SpringMicroservices.EmployeeService.openFeing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.SpringMicroservices.EmployeeService.Response.AddressReponse;

@FeignClient(name="ADDRESSSERVICE", path = "address-app/api")
public interface EmployeeFeign {
	

	@GetMapping("/address/{employeeId}")
	AddressReponse getAddressByEmployeeId(@PathVariable("employeeId") int id);

}
