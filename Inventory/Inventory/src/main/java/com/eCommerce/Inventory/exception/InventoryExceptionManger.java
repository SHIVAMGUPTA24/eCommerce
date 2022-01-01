package com.eCommerce.Inventory.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InventoryExceptionManger extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(BadDataException.class)
	 public final ResponseEntity<InventoryException> manageBadDataException(BadDataException e) {
	    InventoryException inventoryException = new InventoryException(new Date(), e.getMessage());
	    return new ResponseEntity<>(inventoryException, HttpStatus.BAD_REQUEST);
	 }

}