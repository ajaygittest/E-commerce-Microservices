package com.SpringMicroservices.EmployeeService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringMicroservices.EmployeeService.Entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
