package com.customer.customerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.customer.customerService.entity.ShippingAddress;
import com.customer.customerService.service.ShippingAddressService;

@RestController
@RequestMapping("/shippingAddress")
public class ShippingAddressController {

	@Autowired
	ShippingAddressService shippingAddressService;
	
	// FIND CUSTOMER SHIPPING ADDRESS
	@GetMapping("/{sId}")
	public ResponseEntity<?> searchCustomerShippingAddress(@PathVariable("sId") int sId){
		ResponseEntity<?> response = shippingAddressService.getCustomerShippingAddress(sId);
		return response;
	}
	
	// ADD CUSTOMER SHIPPING ADDRESS
	@PostMapping("/{customerId}")
	public ResponseEntity<?> addCustomerShippingAddress(@PathVariable("customerId") int customerId, @RequestBody ShippingAddress shippingAddress) {
	ResponseEntity<?> response = shippingAddressService.createCustomerShippingAddress(customerId, shippingAddress);
	return response;
	}

	// UPDATE CUSTOMER SHIPPING ADDRESS
	@PutMapping("/{sId}")
	public ResponseEntity<?> updateCustomerShippingAddress(@PathVariable("sId") int sId, @RequestBody ShippingAddress shippingAddress) {
	ResponseEntity<?> response = shippingAddressService.updateCustomerShippingAddress(sId, shippingAddress);
	return response;
	}

	// DELETE CUSTOMER SHIPPING ADDRESS
	@DeleteMapping("/{sId}")
	public ResponseEntity<?> deleteCustomerShippingAddress(@PathVariable("sId") int sId) {
	ResponseEntity<?> response = shippingAddressService.deleteCustomerShippingAddress(sId);
	return response;
	}
	
}
