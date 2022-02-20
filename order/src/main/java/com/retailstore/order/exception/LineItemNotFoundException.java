package com.retailstore.order.exception;

public class LineItemNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public LineItemNotFoundException(String message) {
		super(message);
	}

}
