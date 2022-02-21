package com.customer.customerService.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.customer.customerService.dao.CustomerRepository;
import com.customer.customerService.entity.Customer;
import com.customer.customerService.exceptions.BadDataException;
import com.customer.customerService.exceptions.CustomerNotFoundException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	// TO GET A CUSTOMER
	@Override
	public ResponseEntity<?> getCustomer(int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> findById = customerRepo.findById(customerId);
		if(findById.isPresent()) {
			return new ResponseEntity<>(findById.get(),HttpStatus.OK);
		}
		else {
			throw new CustomerNotFoundException("There is no customer with this customerId");
		}
	}

	// TO CREATE A CUSTOMER
	@Override
	public ResponseEntity<?> createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		if(customer.getCustomerName().equals("") || customer.getCustomerEmail().equals("") || customer==null){
			throw new BadDataException("Name/Email cannot be empty");
		}
		ResponseEntity<?> response = new ResponseEntity<>(customerRepo.save(customer), HttpStatus.CREATED);
		return response;
	}

	// TO UPDATE A CUSTOMER
	@Override
	public ResponseEntity<?> updateCustomer(int customerId, Customer customer) {
		// TODO Auto-generated method stub
		Optional<Customer> findById = customerRepo.findById(customerId);
		if(findById.isPresent()) {
			customer.setCustomerId(customerId);
			return new ResponseEntity<>(customerRepo.save(customer),HttpStatus.OK);
		}
		else {
			throw new CustomerNotFoundException("There is no customer with this customerId");
		}
	}

	// TO DELETE A CUSTOMER
	@Override
	public ResponseEntity<?> deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> findById = customerRepo.findById(customerId);
		if(findById.isPresent()) {
			customerRepo.deleteById(customerId);
			return new ResponseEntity<>("Customer is deleted",HttpStatus.OK);
		}
		else {
			throw new CustomerNotFoundException("There is no customer with this customerId");
		}
	}
	
}
