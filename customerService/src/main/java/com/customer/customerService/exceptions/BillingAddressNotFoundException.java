package com.customer.customerService.exceptions;

public class BillingAddressNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BillingAddressNotFoundException(String message) {
		super(message);
	}
}
