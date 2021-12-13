package com.cart.cartService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cart.cartService.dao.LineItemRepository;
import com.cart.cartService.entity.LineItem;
import com.cart.cartService.exceptions.BadDataException;
import com.cart.cartService.exceptions.LineItemNotFoundException;

@Service
@Transactional
public class LineItemServiceImpl implements LineItemService {

	@Autowired
	LineItemRepository lineItemRepo;

//	@Override
//	public ResponseEntity<?> getLineItemByCustomerAndProductId(int customerId, int productId) {
//		Optional<LineItem> findById = lineItemRepo.findByCustomerIdAndProductId(customerId, productId);
//		if (!findById.isPresent()) {
//		throw new CartNotFoundException(
//		"There is no line item with this line item id please check your line item id!");
//		}
//		return new ResponseEntity<>(findById, HttpStatus.OK);
//		return null;
//	}

	@Override
	public ResponseEntity<?> getLineItems(int customerId) {
		List<LineItem> lineItems = lineItemRepo.findByCustomerId(customerId);
		if (lineItems.isEmpty()) {
			return new ResponseEntity<>("Cart is empty", HttpStatus.OK);
		}
		return new ResponseEntity<>(lineItemRepo.findByCustomerId(customerId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createLineItem(LineItem lineItem) {
		int addedQuantity = lineItem.getQuantity();
		if (addedQuantity <= 0) {
			throw new BadDataException("Quantity cannot be less than 1");
		}
		LineItem item = lineItemRepo.findByCustomerIdAndProductId(lineItem.getCustomerId(), lineItem.getProductId());
		if (item != null) {
			addedQuantity = item.getQuantity() + lineItem.getQuantity();
			item.setQuantity(addedQuantity);
		} else {
			item = lineItem;
		}
		return new ResponseEntity<>(lineItemRepo.save(item), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> updateLineItem(int quantity, int customerId, int productId) {
		if (quantity <= 0) {
			throw new BadDataException("Quantity cannot be less than 1");
		}
		int updated = lineItemRepo.updateQuantity(quantity, customerId, productId);
		if(updated==0) {
			throw new LineItemNotFoundException("Please enter valid customerId/productId");
		}
		return new ResponseEntity<>("Line Item Updated", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteLineItem(int customerId, int productId) {
		int deleted = lineItemRepo.deleteByCustomerIdAndProductId(customerId, productId);
		if(deleted==0) {
			throw new LineItemNotFoundException("Please enter valid customerId/productId");
		}
		return new ResponseEntity<>("Line Item Deleted", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> emptyCart(int customerId) {
		lineItemRepo.deleteAllByCustomerId(customerId);
		return new ResponseEntity<>("Cart is Emptied", HttpStatus.OK);
	}

}
