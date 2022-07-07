package com.mneumann1.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mneumann1.model.OrderCreateRequest;
import com.mneumann1.model.OrderPosition;
import com.mneumann1.model.OrderResponse;
import com.mneumann1.model.OrderStatus;


public class OrderRepository {
	
	private List<OrderResponse> orders = new ArrayList<>();

	public OrderResponse save(OrderCreateRequest request) {
		OrderResponse response = new OrderResponse(
				UUID.randomUUID().toString(),
				request.getCustomerId(),
				LocalDateTime.now(),
				OrderStatus.NEW, 
				new ArrayList<OrderPosition>());
		
		orders.add(response);
		return response;
	}

}
