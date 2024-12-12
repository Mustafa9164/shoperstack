package com.jsp.prc.exception;

public class ProductNotFoundException extends RuntimeException {
	
	private String message;

	public ProductNotFoundException(String message) {
		super();
		this.message = message;
	}
	public ProductNotFoundException() {
		super();
		
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
	

}
