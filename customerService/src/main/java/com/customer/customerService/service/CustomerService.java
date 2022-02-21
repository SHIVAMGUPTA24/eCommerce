package com.customer.customerService.service;

import org.springframework.http.ResponseEntity;

import com.customer.customerService.entity.Customer;

public interface CustomerService {
	
	ResponseEntity<?> getCustomer(int customerId);
	
	ResponseEntity<?> createCustomer(Customer customer);

	ResponseEntity<?> updateCustomer(int customerId, Customer customer);

	ResponseEntity<?> deleteCustomer(int customerId);
	
}
