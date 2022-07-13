package com.mneumann1.exceptions;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class WebshopException extends RuntimeException {
	
	private String message;
	private HttpStatus statusCode;
	
	public WebshopException(String message, HttpStatus statusCode) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
