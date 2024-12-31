package com.microserviceDemo.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microserviceDemo.ProductService.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
