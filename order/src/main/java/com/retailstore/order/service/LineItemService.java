package com.retailstore.order.service;

import com.retailstore.order.entity.LineItem;
import org.springframework.http.ResponseEntity;

public interface LineItemService {

    ResponseEntity<?> getLineItemById(int id);

    ResponseEntity<?> createLineItem(LineItem lineItem);

    ResponseEntity<?> updateLineItem(int quantity, int productId, int cartId);

    ResponseEntity<?> deleteLineItem(int productId, int cartId);
}
