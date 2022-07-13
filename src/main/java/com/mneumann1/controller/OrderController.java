package com.mneumann1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mneumann1.exceptions.WebshopException;
import com.mneumann1.model.OrderCreateRequest;
import com.mneumann1.model.OrderPositionCreateRequest;
import com.mneumann1.model.OrderResponse;
import com.mneumann1.repository.OrderRepository;
import com.mneumann1.service.OrderService;

@RestController
public class OrderController {
	
	// Dependency Injection
	private OrderService orderService;
	private OrderRepository orderRepository;
	
	public OrderController(OrderService orderService, OrderRepository orderRepository) {
		this.orderService = orderService;
		this.orderRepository = orderRepository;
	}
	
	@GetMapping("/orders")
	public List<OrderResponse> getAllOrders(){
		return orderRepository.findAll();
	}

		
	@PostMapping("/orders")
	public OrderResponse createOrder(@RequestBody OrderCreateRequest request) throws WebshopException {	
		return orderService.createOrder(request);			
	}
	
	@PostMapping("/orders/{id}/positions")
	public void createOrderPosition(@PathVariable(name = "id") String orderId, @RequestBody OrderPositionCreateRequest request) throws WebshopException {
		orderService.createNewPositionForOrder(orderId, request);
	}

}
