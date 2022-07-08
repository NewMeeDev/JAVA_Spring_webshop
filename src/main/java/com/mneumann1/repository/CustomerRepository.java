package com.mneumann1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.mneumann1.model.CustomerResponse;

public class CustomerRepository {

	private List<CustomerResponse> customers = new ArrayList<>();
	
	
	public CustomerRepository() {
//		customers.add(new CustomerResponse(UUID.randomUUID().toString(), "Max", "Lange", "max.lange@web.de"));
//		customers.add(new CustomerResponse(UUID.randomUUID().toString(), "Karl", "Richter", "karl-richter@mail.org"));
//		customers.add(new CustomerResponse(UUID.randomUUID().toString(), "Friedrich", "Schiller", "fs123@gmail.com"));
		customers.add(new CustomerResponse("1", "Max", "Lange", "max.lange@web.de"));
		customers.add(new CustomerResponse("2", "Karl", "Richter", "karl-richter@mail.org"));
		customers.add(new CustomerResponse("3", "Friedrich", "Schiller", "fs123@gmail.com"));
		}
	
	
	public Optional<CustomerResponse> findById(String id) {
		Optional<CustomerResponse> customer = customers.stream()
				.filter(c -> c.getId().equals(id))
				.findFirst();
		return customer;
	}


	public List<CustomerResponse> findAll() {
		return customers.stream().
				collect(Collectors.toList());
	}

}
