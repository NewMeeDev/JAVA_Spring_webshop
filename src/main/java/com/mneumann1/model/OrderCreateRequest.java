package com.mneumann1.model;

public class OrderCreateRequest {
	
	private String customerId;
	
	// empty Constructor or ...
	public OrderCreateRequest() {};
	// ... add @JsonProperty() to every parameter

	public OrderCreateRequest(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerId() {
		return customerId;
	}
	
}
