package com.eCommerce.Inventory.exception;

import java.time.ZonedDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InventoryExceptionManger extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(BadDataException.class)
	 @ResponseBody 
	 ResponseEntity<InventoryException> manageBadDataException(BadDataException e,HttpServletRequest req) {
	    return new ResponseEntity<InventoryException>(new InventoryException(
			e.getMessage(),HttpStatus.BAD_REQUEST,ZonedDateTime.now())
			,HttpStatus.BAD_REQUEST);
	 }
	 @ExceptionHandler(InventoryNotFoundException.class)
	 @ResponseBody 
	 ResponseEntity<InventoryException> manageBadDataException(InventoryNotFoundException e,HttpServletRequest req) {
	    return new ResponseEntity<InventoryException>(new InventoryException(
			e.getMessage(),HttpStatus.NOT_FOUND,ZonedDateTime.now())
			,HttpStatus.NOT_FOUND);
	 }

}