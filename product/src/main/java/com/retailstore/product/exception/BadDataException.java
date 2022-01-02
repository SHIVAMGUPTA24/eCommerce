package com.retailstore.product.exception;

public class BadDataException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BadDataException(String message) {
		super(message);
	}

}
