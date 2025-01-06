package com.SpringMicroservices.AddressService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SpringMicroservices.AddressService.Entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
	
	
	@Query(nativeQuery = true,value="SELECT t1.id,t1.lane1,t1.lane2,t1.zip,t1.state FROM springmicroservice.address t1 join springmicroservice.employee t2 on t2.id=t1.employee_id where t1.employee_id=:employeeId")
	Address findAddressByEmployeeId(@Param("employeeId") int employeeId);

}
