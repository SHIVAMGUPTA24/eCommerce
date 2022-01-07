package com.customer.customerService.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.customer.customerService.dao.CustomerRepository;
import com.customer.customerService.dao.ShippingAddressRepository;
import com.customer.customerService.entity.Customer;
import com.customer.customerService.entity.ShippingAddress;
import com.customer.customerService.exceptions.BadDataException;
import com.customer.customerService.exceptions.ShippingAddressNotFoundException;

@Service
@Transactional
public class ShippingAddressServiceImpl implements ShippingAddressService {

	@Autowired
	ShippingAddressRepository shippingAddressRepo;
	
	@Autowired
	CustomerRepository customerRepo;

	// TO GET A CUSTOMER SHIPPING ADDRESS
	@Override
	public ResponseEntity<?> getCustomerShippingAddress(int sId) {
		// TODO Auto-generated method stub
		Optional<ShippingAddress> findById = shippingAddressRepo.findById(sId);
		if(findById.isPresent()) {
			return new ResponseEntity<>(findById.get(),HttpStatus.OK);
		}
		else {
			throw new ShippingAddressNotFoundException("There is no shipping addrress with this sId");
		}
	}

	// TO CREATE A CUSTOMER SHIPPING ADDRESS
	@Override
	public ResponseEntity<?> createCustomerShippingAddress(int customerId, ShippingAddress shippingAddress) {
		// TODO Auto-generated method stub
		if(shippingAddress.getDoorNo().equals("") || shippingAddress.getStreetName().equals("") || shippingAddress.getLandmark().equals("") || shippingAddress.getPincode().equals("") || shippingAddress.getCity().equals("") || shippingAddress==null){
			throw new BadDataException("Please fill all the fields");
		}
		Optional<Customer> findById = customerRepo.findById(customerId);
		shippingAddress.setCustomer(findById.get());
		ResponseEntity<?> response = new ResponseEntity<>(shippingAddressRepo.save(shippingAddress), HttpStatus.CREATED);
		return response;
	}

	// TO UPDATE A CUSTOMER SHIPPING ADDRESS
	@Override
	public ResponseEntity<?> updateCustomerShippingAddress(int sId, ShippingAddress shippingAddress) {
		// TODO Auto-generated method stub
		Optional<ShippingAddress> findById = shippingAddressRepo.findById(sId);
		if(findById.isPresent()) {
			shippingAddress.setCustomer(findById.get().getCustomer());
			return new ResponseEntity<>(shippingAddressRepo.save(shippingAddress),HttpStatus.OK);
		}
		else {
			throw new ShippingAddressNotFoundException("There is no shipping addrress with this sId");
		}
	}

	// TO DELETE A CUSTOMER SHIPPING ADDRESS
	@Override
	public ResponseEntity<?> deleteCustomerShippingAddress(int sId) {
		// TODO Auto-generated method stub
		Optional<ShippingAddress> findById = shippingAddressRepo.findById(sId);
		if(findById.isPresent()) {
			shippingAddressRepo.deleteBySId(sId);
			return new ResponseEntity<>("Shipping Address is deleted",HttpStatus.OK);
		}
		else {
			throw new ShippingAddressNotFoundException("There is no shipping addrress with this sId");
		}
	}
	
}
