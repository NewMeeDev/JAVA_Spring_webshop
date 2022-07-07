package com.mneumann1.model;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
	
	private String id;
	private String customerId;
	private LocalDateTime orderTime;
	private OrderStatus orderStatus;
	private List<OrderPosition> orderPositions;
	
	
	public OrderResponse(String id, String customerId, LocalDateTime orderTime, OrderStatus status,	List<OrderPosition> orderPositions) {
		this.id = id;
		this.customerId = customerId;
		this.orderTime = orderTime;
		this.orderStatus = status;
		this.orderPositions = orderPositions;
	}

	public String getId() {
		return id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public List<OrderPosition> getOrderPositions() {
		return orderPositions;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

}


