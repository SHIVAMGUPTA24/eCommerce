package com.retailstore.order.service;

import com.retailstore.order.entity.OrdersLineItem;
import org.springframework.http.ResponseEntity;

public interface OrderLineItemService {
//ResponseEntity<?> getLineItemByCustomerAndProductId(int customerId, int productId);

    ResponseEntity<?> getLineItems(int customerId);

    ResponseEntity<?> createLineItem(OrdersLineItem lineItem);

    ResponseEntity<?> updateLineItem(int quantity, int customerId, int productId);

    ResponseEntity<?> deleteLineItem(int customerId, int productId);

    ResponseEntity<?> emptyCart(int customerId);

}
