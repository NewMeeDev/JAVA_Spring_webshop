package com.mneumann1.model;

import java.util.List;

//import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCreateRequest {
	
	private String name;
	private String description;
	private int priceInCent;
	private List<String> tags;
	
	// empty Constructor or ...
	public ProductCreateRequest() {};
	// ... add @JsonProperty() to every parameter
	// public ProductCreateRequest(@JsonProperty("name")String name, @JsonProperty("description")String description, @JsonProperty("priceInCent")int priceInCent, @JsonProperty("tags")List<String> tags) {
	
	public ProductCreateRequest(String name, String description, int priceInCent, List<String> tags) {

		this.name = name;
		this.description = description;
		this.priceInCent = priceInCent;
		this.tags = tags;
	}


	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getPriceInCent() {
		return priceInCent;
	}

	public List<String> getTags() {
		return tags;
	}
	
	
	

}
