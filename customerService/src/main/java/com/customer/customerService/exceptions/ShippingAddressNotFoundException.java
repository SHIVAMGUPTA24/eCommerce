package com.customer.customerService.exceptions;

public class ShippingAddressNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ShippingAddressNotFoundException(String message) {
		super(message);
	}
	
}
