package com.retailstore.order.service;

import com.retailstore.order.entity.Order;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<?> getOrderById(int id);

    ResponseEntity<?> createOrder(Order order);

    ResponseEntity<?> updateOrder(int id, Order order);

    ResponseEntity<?> deleteOrder(int id);
}
