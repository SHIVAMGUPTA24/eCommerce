package com.eCommerce.Inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RedundantDataException extends RuntimeException{
	public RedundantDataException(String e) {
	    super(e);
	  }
}
