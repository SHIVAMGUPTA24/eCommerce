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

import com.customer.customerService.entity.BillingAddress;
import com.customer.customerService.service.BillingAddressService;

@RestController
@RequestMapping("/billingAddress")
public class BillingAddressController {

	@Autowired
	BillingAddressService billingAddressService;
	
	// FIND CUSTOMER BILLING ADDRESS
	@GetMapping("/{bId}")
	public ResponseEntity<?> searchCustomerBillingAddress(@PathVariable("bId") int bId){
		ResponseEntity<?> response = billingAddressService.getCustomerBillingAddress(bId);
		return response;
	}
	
	// ADD CUSTOMER BILLING ADDRESS
	@PostMapping("/{customerId}")
	public ResponseEntity<?> addCustomerbillingAddress(@PathVariable("customerId") int customerId, @RequestBody BillingAddress billingAddress) {
	ResponseEntity<?> response = billingAddressService.createCustomerBillingAddress(customerId, billingAddress);
	return response;
	}

	// UPDATE CUSTOMER BILLING ADDRESS
	@PutMapping("/{bId}")
	public ResponseEntity<?> updateCustomerbillingAddress(@PathVariable("bId") int bId, @RequestBody BillingAddress billingAddress) {
	ResponseEntity<?> response = billingAddressService.updateCustomerBillingAddress(bId, billingAddress);
	return response;
	}

	// DELETE CUSTOMER BILLING ADDRESS
	@DeleteMapping("/{bId}")
	public ResponseEntity<?> deleteCustomerbillingAddress(@PathVariable("bId") int bId) {
	ResponseEntity<?> response = billingAddressService.deleteCustomerBillingAddress(bId);
	return response;
	}
	
}
