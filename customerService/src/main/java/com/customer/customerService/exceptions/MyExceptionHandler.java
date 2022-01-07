package com.customer.customerService.exceptions;

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
	ResponseEntity<CustomerExceptions> badData(BadDataException e) {
		return new ResponseEntity<CustomerExceptions>(
				new CustomerExceptions(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z"))),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseBody
	ResponseEntity<CustomerExceptions> customerNotFound(CustomerNotFoundException e) {
		return new ResponseEntity<CustomerExceptions>(
				new CustomerExceptions(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Z"))),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ShippingAddressNotFoundException.class)
	@ResponseBody
	ResponseEntity<CustomerExceptions> shippingAddressNotFound(ShippingAddressNotFoundException e) {
		return new ResponseEntity<CustomerExceptions>(
				new CustomerExceptions(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Z"))),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BillingAddressNotFoundException.class)
	@ResponseBody
	ResponseEntity<CustomerExceptions> billingAddressNotFound(BillingAddressNotFoundException e) {
		return new ResponseEntity<CustomerExceptions>(
				new CustomerExceptions(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Z"))),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	ResponseEntity<CustomerExceptions> notAppropriate(Exception e) {
		return new ResponseEntity<CustomerExceptions>(
				new CustomerExceptions(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z"))),
				HttpStatus.BAD_REQUEST);
	}

}
