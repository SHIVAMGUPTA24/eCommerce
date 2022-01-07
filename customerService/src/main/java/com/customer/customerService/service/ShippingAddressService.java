package com.customer.customerService.service;

import org.springframework.http.ResponseEntity;

import com.customer.customerService.entity.ShippingAddress;

public interface ShippingAddressService {

	ResponseEntity<?> getCustomerShippingAddress(int sId);
	
	ResponseEntity<?> createCustomerShippingAddress(int customerId, ShippingAddress shippingAddress);

	ResponseEntity<?> updateCustomerShippingAddress(int sId, ShippingAddress shippingAddress);

	ResponseEntity<?> deleteCustomerShippingAddress(int sId);
	
}
