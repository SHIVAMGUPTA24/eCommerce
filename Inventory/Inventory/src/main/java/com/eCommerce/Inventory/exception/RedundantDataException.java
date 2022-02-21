package com.eCommerce.Inventory.exception;

public class RedundantDataException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RedundantDataException(String e) {
	    super(e);
	  }
}
