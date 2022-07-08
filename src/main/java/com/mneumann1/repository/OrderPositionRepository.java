package com.mneumann1.repository;

import java.util.ArrayList;
import java.util.List;

import com.mneumann1.model.OrderPositionResponse;

public class OrderPositionRepository {
	
	List<OrderPositionResponse> orderPositions = new ArrayList<>();
	
	public void save(OrderPositionResponse orderPositionResponse) {
		
		orderPositions.add(orderPositionResponse);
		
	}

}
