package com.eCommerce.Inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InventoryNotFoundException extends RuntimeException {
	
	public InventoryNotFoundException(String e) {
	    super(e);
	  }
}
