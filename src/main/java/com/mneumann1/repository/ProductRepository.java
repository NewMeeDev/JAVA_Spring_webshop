package com.mneumann1.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mneumann1.model.ProductCreateRequest;
import com.mneumann1.model.ProductResponse;

@Service
public class ProductRepository {
	
	private List<ProductResponse> products = new ArrayList<>();
	
		
	public ProductRepository() {
		products.add(new ProductResponse(UUID.randomUUID().toString(), "AMD Ryzen 5950X", "A very super processor!", 59900, Arrays.asList("AMD", "processor")));
		products.add(new ProductResponse(UUID.randomUUID().toString(), "Intel XEON v3123", "A processor mainly for servers!", 37900, Arrays.asList("Intel", "processor")));
		products.add(new ProductResponse(UUID.randomUUID().toString(), "NVIDIA GeForce GTX 1080 Ti Black Edition 11GB", "A very goog gaming graphics card!", 74900, Arrays.asList("Intel", "graphics")));
//		products.add(new ProductResponse("1", "AMD Ryzen 5950X", "A very super processor!", 59900, Arrays.asList("AMD", "processor")));
//		products.add(new ProductResponse("2", "Intel XEON v3123", "A processor mainly for servers!", 37900, Arrays.asList("Intel", "processor")));
//		products.add(new ProductResponse("3", "NVIDIA GeForce GTX 1080 Ti Black Edition 11GB", "A very goog gaming graphics card!", 74900, Arrays.asList("Intel", "graphics")));
	}

	
	private List<String> lowerCaseTags(ProductResponse p) {
		
		return p.getTags().stream()
				.map(tag -> tag.toLowerCase())
				.collect(Collectors.toList());
	}
	
	
	public List<ProductResponse> findAll(String tag) {
	
		if (tag == null) {
			return products;
			
		} else {
			
			String lowerCaseTag = tag.toLowerCase();
						
			return products.stream().
				filter(p -> lowerCaseTags(p).contains(lowerCaseTag)).
				collect(Collectors.toList());
		}
	}


	public Optional<ProductResponse> findById(String id) {
		Optional<ProductResponse> product = products.stream()
				.filter(p -> p.getId().equals(id))
				.findFirst();
		return product;
	}


	public void deleteById(String id) {
		this.products = products.stream()
				.filter(p -> !p.getId().equals(id))
				.collect(Collectors.toList());
		
	}


	public ProductResponse save(ProductCreateRequest request) {
		ProductResponse response = new ProductResponse(
				UUID.randomUUID().toString(),
				request.getName(),
				request.getDescription(),
				request.getPriceInCent(),
				request.getTags()
				);
		
		products.add(response);
		return response;
	}

	
}
