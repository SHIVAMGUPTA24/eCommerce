package com.customer.customerService.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.customer.customerService.dao.BillingAddressRepository;
import com.customer.customerService.dao.CustomerRepository;
import com.customer.customerService.entity.BillingAddress;
import com.customer.customerService.entity.Customer;
import com.customer.customerService.exceptions.BadDataException;
import com.customer.customerService.exceptions.BillingAddressNotFoundException;

@Service
@Transactional
public class BillingAddressServiceImpl implements BillingAddressService {

	@Autowired
	BillingAddressRepository billingAddressRepo;
	
	@Autowired
	CustomerRepository customerRepo;

	// TO GET A CUSTOMER BILLING ADDRESS
	@Override
	public ResponseEntity<?> getCustomerBillingAddress(int bId) {
		// TODO Auto-generated method stub
		Optional<BillingAddress> findById = billingAddressRepo.findById(bId);
		if(findById.isPresent()) {
			return new ResponseEntity<>(findById.get(),HttpStatus.OK);
		}
		else {
			throw new BillingAddressNotFoundException("There is no billing addrress with this bId");
		}
	}

	// TO CREATE A CUSTOMER BILLING ADDRESS
	@Override
	public ResponseEntity<?> createCustomerBillingAddress(int customerId, BillingAddress billingAddress) {
		// TODO Auto-generated method stub
		if(billingAddress.getDoorNo().equals("") || billingAddress.getStreetName().equals("") || billingAddress.getLandmark().equals("") || billingAddress.getPincode().equals("") || billingAddress.getCity().equals("") || billingAddress==null){
			throw new BadDataException("Please fill all the fields");
		}
		Optional<Customer> findById = customerRepo.findById(customerId);
		billingAddress.setCustomer(findById.get());
		ResponseEntity<?> response = new ResponseEntity<>(billingAddressRepo.save(billingAddress), HttpStatus.CREATED);
		return response;
	}

	// TO UPDATE A CUSTOMER BILLING ADDRESS
	@Override
	public ResponseEntity<?> updateCustomerBillingAddress(int bId, BillingAddress billingAddress) {
		// TODO Auto-generated method stub
		Optional<BillingAddress> findById = billingAddressRepo.findById(bId);
		if(findById.isPresent()) {
			billingAddress.setCustomer(findById.get().getCustomer());
			return new ResponseEntity<>(billingAddressRepo.save(billingAddress),HttpStatus.OK);
		}
		else {
			throw new BillingAddressNotFoundException("There is no billing addrress with this bId");
		}
	}

	// TO DELETE A CUSTOMER BILLING ADDRESS
	@Override
	public ResponseEntity<?> deleteCustomerBillingAddress(int bId) {
		// TODO Auto-generated method stub
		Optional<BillingAddress> findById = billingAddressRepo.findById(bId);
		if(findById.isPresent()) {
			billingAddressRepo.deleteByBId(bId);
			return new ResponseEntity<>("Billing Address is deleted",HttpStatus.OK);
		}
		else {
			throw new BillingAddressNotFoundException("There is no billing addrress with this bId");
		}
	}
	
}
