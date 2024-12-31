package com.microserviceDemo.ProductService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microserviceDemo.ProductService.Entity.Product;
import com.microserviceDemo.ProductService.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class Controller {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return this.productRepository.save(product);
	}
	
	@GetMapping("/allProduct")
	public List<Product> getAllProduct() {
		return this.productRepository.findAll();
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
		
		Product product=productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product Not found"));
		return ResponseEntity.ok(product);
	}

}
