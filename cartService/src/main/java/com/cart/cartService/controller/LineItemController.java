package com.cart.cartService.controller;

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

import com.cart.cartService.entity.LineItem;
import com.cart.cartService.service.LineItemService;

@RestController
@RequestMapping("/lineItem")
public class LineItemController {

	@Autowired
	LineItemService lineItemService;
	
	@GetMapping("/getmessage")
	public String getMessage() {
		return "This message is from cart";
	}
	
	// SEARCH LINE ITEM
//	@GetMapping("/{customerId}/{productId}")
//	public ResponseEntity<?> searchLineItem(@PathVariable("customerId") int customerId, @PathVariable("productId") int productId) {
//	ResponseEntity<?> response = lineItemService.getLineItemByCustomerAndProductId(customerId, productId);
//	return response;
//	}
	
	// FIND ALL LINE ITEMS
	@GetMapping("/{customerId}")
	public ResponseEntity<?> searchLineItem(@PathVariable("customerId") int customerId){
		ResponseEntity<?> response = lineItemService.getLineItems(customerId);
		return response;
	}
	

	// ADD LINE ITEM
	@PostMapping("/")
	public ResponseEntity<?> addLineItem(@RequestBody LineItem lineItem) {
	ResponseEntity<?> response = lineItemService.createLineItem(lineItem);
	return response;
	}

	// UPDATE LINE ITEM
	@PutMapping("/{quantity}/{customerId}/{productId}")
	public ResponseEntity<?> updateLineItem(@PathVariable("quantity") int quantity,
	@PathVariable("customerId") int customerId, @PathVariable("productId") int productId) {
	ResponseEntity<?> response = lineItemService.updateLineItem(quantity, customerId, productId);
	return response;
	}

	// DELETE LINE ITEM
	@DeleteMapping("/{customerId}/{productId}")
	public ResponseEntity<?> deleteLineItem(@PathVariable("customerId") int customerId,
	@PathVariable("productId") int productId) {
	ResponseEntity<?> response = lineItemService.deleteLineItem(customerId, productId);
	return response;
	}
	
	// EMPTY CART
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> emptyCart(@PathVariable("customerId") int customerId) {
	ResponseEntity<?> response = lineItemService.emptyCart(customerId);
	return response;
	}
}

/*
{
    "itemId": 1,
    "productId": 1,
    "productName": "Samsung",
    "quantity": 10,
    "price": 100.0,
    "customerId": 101
}
*/
