package com.mneumann1.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mneumann1.model.OrderCreateRequest;
import com.mneumann1.model.OrderPosition;
import com.mneumann1.model.OrderResponse;
import com.mneumann1.model.OrderStatus;

@Service
public class OrderRepository {
	
	private List<OrderResponse> orders = new ArrayList<>();
	
	public List<OrderResponse> findAll() {
		return orders.stream().collect(Collectors.toList());
	}
	

	public OrderResponse save(OrderCreateRequest request) {
		OrderResponse orderResponse = new OrderResponse(
				UUID.randomUUID().toString(),
				request.getCustomerId(),
				LocalDateTime.now(),
				OrderStatus.NEW, 
				new ArrayList<OrderPosition>());
		
		orders.add(orderResponse);
		return orderResponse;
	}


	public Optional<OrderResponse> findById(String id) {
		Optional<OrderResponse> order = orders.stream()
				.filter(o -> o.getId().equals(id))
				.findFirst();
		return order;
	}
	
}
