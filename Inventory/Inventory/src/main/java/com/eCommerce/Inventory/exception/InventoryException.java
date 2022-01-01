package com.eCommerce.Inventory.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InventoryException{
	
	private Date date;
	private String message;
}
