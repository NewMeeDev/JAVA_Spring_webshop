package com.mneumann1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mneumann1.model.CustomerResponse;
import com.mneumann1.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	private CustomerRepository customerRepository = new CustomerRepository();
	
	
	@GetMapping("/customers")
	public List<CustomerResponse> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String id) {
		Optional<CustomerResponse> customer = customerRepository.findById(id);
		
		if(customer.isPresent()) {
			return ResponseEntity.ok(customer.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	} 
	

}
