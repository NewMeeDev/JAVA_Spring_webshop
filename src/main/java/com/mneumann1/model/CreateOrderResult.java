package com.mneumann1.model;

import java.util.List;

//WrapperClass
public class CreateOrderResult {
	private OrderResponse result;
	private List<ErrorResponse> errors;
	
	public CreateOrderResult(OrderResponse result, List<ErrorResponse> errors) {
		this.result = result;
		this.errors = errors;
	}

	public OrderResponse getResult() {
		return result;
	}

	public List<ErrorResponse> getErrors() {
		return errors;
	}
}
