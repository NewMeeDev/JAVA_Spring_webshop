package com.mneumann1.model;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private HttpStatus code;
	private String message;
	
	public ErrorResponse(HttpStatus code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public HttpStatus getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	
}
