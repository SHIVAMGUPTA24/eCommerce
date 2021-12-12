package com.cart.cartService.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cart.cartService.dao.LineItemRepository;
import com.cart.cartService.entity.LineItem;

@Service
@Transactional
public class LineItemServiceImpl implements LineItemService {
	
	@Autowired
	LineItemRepository lineItemRepo;

	@Override
	public ResponseEntity<?> getLineItemById(int id) {
		
		return null;
	}

	@Override
	public ResponseEntity<?> getLineItemByCustomerAndProductId(int customerId, int productId) {
		
		return null;
	}

	@Override
	public ResponseEntity<?> createLineItem(LineItem lineItem) {
		
		return null;
	}

	@Override
	public ResponseEntity<?> updateLineItem(int quantity, int productId, int customerId) {
		
		return null;
	}

	@Override
	public ResponseEntity<?> deleteLineItem(int productId, int customerId) {
		
		return null;
	}

}
