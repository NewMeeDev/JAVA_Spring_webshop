package com.mneumann1.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mneumann1.model.OrderPositionResponse;

@Service
public class OrderPositionRepository {
	
	List<OrderPositionResponse> orderPositions = new ArrayList<>();
	
	public void save(OrderPositionResponse orderPositionResponse) {
		
		orderPositions.add(orderPositionResponse);
		
	}

}
