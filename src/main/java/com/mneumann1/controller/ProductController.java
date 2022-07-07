package com.mneumann1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import com.mneumann1.model.ProductResponse;
import com.mneumann1.model.ProductCreateRequest;
import com.mneumann1.repository.ProductRepository;

@RestController
public class ProductController {
	
	private ProductRepository productRepository = new ProductRepository();

	
	@GetMapping("/products")
	public List<ProductResponse> getAllProducts(@RequestParam(required = false) String tag) {
		return productRepository.findAll(tag);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
		Optional<ProductResponse> product = productRepository.findById(id);
		
		if(product.isPresent()) {
			return ResponseEntity.ok(product.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<ProductResponse> deleteProduct(@PathVariable String id) {
		productRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/products")
	public ProductResponse createProduct(@RequestBody ProductCreateRequest request) {
		return productRepository.save(request);	
	}
}