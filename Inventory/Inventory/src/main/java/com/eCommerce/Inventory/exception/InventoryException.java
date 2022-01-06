package com.eCommerce.Inventory.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InventoryException extends Throwable{
	
	private Date date;
	private String message;
}
