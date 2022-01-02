package com.retailstore.order.service;

import com.retailstore.order.entity.Order;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<Order> getOrderById(int id);
}
