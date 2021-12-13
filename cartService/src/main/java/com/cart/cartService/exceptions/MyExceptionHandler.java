package com.cart.cartService.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(BadDataException.class)
	@ResponseBody
	ResponseEntity<CartExceptions> badData(BadDataException e) {
		return new ResponseEntity<CartExceptions>(
				new CartExceptions(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z"))),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LineItemNotFoundException.class)
	@ResponseBody
	ResponseEntity<CartExceptions> lineItemNotFound(LineItemNotFoundException e) {
		return new ResponseEntity<CartExceptions>(
				new CartExceptions(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Z"))),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	ResponseEntity<CartExceptions> notAppropriate(Exception e) {
		return new ResponseEntity<CartExceptions>(
				new CartExceptions(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z"))),
				HttpStatus.BAD_REQUEST);
	}

}
