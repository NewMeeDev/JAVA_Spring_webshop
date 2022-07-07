package com.mneumann1.model;

public class OrderPosition {
	
	private String id;
	private String productId;
	private int quantity;
	
	public OrderPosition(String id, String productId, int quantity) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public String getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}
	
}
