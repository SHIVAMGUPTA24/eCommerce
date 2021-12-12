package com.cart.cartService.service;

import org.springframework.http.ResponseEntity;

import com.cart.cartService.entity.LineItem;

public interface LineItemService {

	ResponseEntity<?> getLineItemById(int id);
	
	ResponseEntity<?> getLineItemByCustomerAndProductId(int customerId, int productId);

	ResponseEntity<?> createLineItem(LineItem lineItem);

	ResponseEntity<?> updateLineItem(int quantity, int productId, int customerId);

	ResponseEntity<?> deleteLineItem(int productId, int customerId);

}
