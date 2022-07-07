package com.mneumann1.controller;

import org.springframework.web.bind.annotation.*;

import com.mneumann1.model.OrderCreateRequest;
import com.mneumann1.model.OrderResponse;
import com.mneumann1.repository.OrderRepository;

@RestController
public class OrderController {
	
	private OrderRepository orderRepository = new OrderRepository();
	
	@PostMapping("/orders")
	public OrderResponse createOrder(@RequestBody OrderCreateRequest request) {
		return orderRepository.save(request);	
	}

}
