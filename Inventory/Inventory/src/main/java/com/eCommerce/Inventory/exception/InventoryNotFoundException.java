package com.eCommerce.Inventory.exception;

public class InventoryNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InventoryNotFoundException(String e) {
	    super(e);
	  }
}
