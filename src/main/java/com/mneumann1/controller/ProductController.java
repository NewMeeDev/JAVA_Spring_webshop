package com.mneumann1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mneumann1.model.ProductResponse;
import com.mneumann1.repository.ProductRepository;
import com.mneumann1.model.ProductCreateRequest;

@RestController
public class ProductController {
	
	private ProductRepository productRepository;
	
	// Constructor with Dependency Injection
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
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
