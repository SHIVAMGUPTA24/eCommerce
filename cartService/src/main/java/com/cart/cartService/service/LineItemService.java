package com.cart.cartService.service;

import org.springframework.http.ResponseEntity;

import com.cart.cartService.entity.LineItem;

public interface LineItemService {
	
	//ResponseEntity<?> getLineItemByCustomerAndProductId(int customerId, int productId);

	ResponseEntity<?> getLineItems(int customerId);
	
	ResponseEntity<?> createLineItem(LineItem lineItem);

	ResponseEntity<?> updateLineItem(int quantity, int customerId, int productId);

	ResponseEntity<?> deleteLineItem(int customerId, int productId);
	
	ResponseEntity<?> emptyCart(int customerId);

}
