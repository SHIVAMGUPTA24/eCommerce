package com.eCommerce.Inventory.exception;


import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InventoryException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus status;
	private ZonedDateTime zonedDateTime;

}
