package com.mneumann1.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorInfo> handleErrors(HttpServletRequest request, Exception exception) {
		
		ErrorInfo errorInfo = new ErrorInfo("An error occured!", request.getRequestURI());
		
		if(exception.getMessage() != null) {
			errorInfo = new ErrorInfo(exception.getMessage(), request.getRequestURI());
		}
		
		if (exception instanceof WebshopException) {
			((WebshopException) exception).setMessage(((WebshopException) exception).getStatusCode().toString()); 
		} 
		else if (exception instanceof IdNotFoundException) {
			((IdNotFoundException) exception).setMessage(HttpStatus.NOT_FOUND.toString()); 
		}
			
				
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


class ErrorInfo {
	private String error;
	private String path;

	public ErrorInfo(String error, String path) {
		this.error = error;
		this.path = path;
	}

	public String getError() {
		return error;
	}
	
	public String getPath() {
		return path;
	}
	
	
}
