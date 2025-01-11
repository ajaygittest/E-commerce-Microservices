package com.SpringMicroservices.EmployeeService.openFeing;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import com.SpringMicroservices.EmployeeService.configuration.MyCustomLoadBalancerConfiguration;

import feign.Feign;

@LoadBalancerClient(name="ADDRESSSERVICE", configuration = MyCustomLoadBalancerConfiguration.class)
public class AddressServiceLoadBalance {
	
	@LoadBalanced
	@Bean
	public Feign.Builder feinBuilder(){
		return Feign.builder();
	}

}
