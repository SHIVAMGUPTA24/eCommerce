package com.customer.customerService.service;

import org.springframework.http.ResponseEntity;

import com.customer.customerService.entity.BillingAddress;

public interface BillingAddressService {

	ResponseEntity<?> getCustomerBillingAddress(int bId);
	
	ResponseEntity<?> createCustomerBillingAddress(int customerId, BillingAddress billingAddress);

	ResponseEntity<?> updateCustomerBillingAddress(int bId, BillingAddress billingAddress);

	ResponseEntity<?> deleteCustomerBillingAddress(int bId);
	
}
