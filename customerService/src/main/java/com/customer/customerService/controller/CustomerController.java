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

import com.customer.customerService.entity.Customer;
import com.customer.customerService.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/getmessage")
	public String getMessage() {
		return "This message is from customer";
	}
	
	// FIND CUSTOMER
	@GetMapping("/{customerId}")
	public ResponseEntity<?> searchCustomer(@PathVariable("customerId") int customerId){
		ResponseEntity<?> response = customerService.getCustomer(customerId);
		return response;
	}
	
	// ADD CUSTOMER
	@PostMapping("/")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
	ResponseEntity<?> response = customerService.createCustomer(customer);
	return response;
	}

	// UPDATE CUSTOMER
	@PutMapping("/{customerId}")
	public ResponseEntity<?> updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
	ResponseEntity<?> response = customerService.updateCustomer(customerId, customer);
	return response;
	}

	// DELETE CUSTOMER
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") int customerId) {
	ResponseEntity<?> response = customerService.deleteCustomer(customerId);
	return response;
	}
	
}
