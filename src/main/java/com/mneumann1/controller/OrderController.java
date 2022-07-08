package com.mneumann1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mneumann1.model.OrderCreateRequest;
import com.mneumann1.model.OrderPosition;
import com.mneumann1.model.OrderPositionCreateRequest;
import com.mneumann1.model.OrderResponse;
import com.mneumann1.model.ProductResponse;
import com.mneumann1.repository.OrderRepository;
import com.mneumann1.service.OrderService;

@RestController
public class OrderController {
	
	private OrderService orderService = new OrderService();
	private OrderRepository orderRepository = new OrderRepository();
	
	@GetMapping("/orders")
	public List<OrderResponse> getAllOrders(){
		return orderRepository.findAll();
	}

		
	@PostMapping("/orders")
	public OrderResponse createOrder(@RequestBody OrderCreateRequest request) {
		return orderService.createOrder(request);	
	}
	
	@PostMapping("/orders/{id}/positions")
	public void orderPosition(@PathVariable(name = "id") String orderId, @RequestBody OrderPositionCreateRequest request) {
		
		orderService.createNewPositionForOrder(orderId, request);
		
	}

}
