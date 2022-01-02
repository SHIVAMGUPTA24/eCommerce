package com.retailstore.order.service;

import com.retailstore.order.entity.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Override
    public ResponseEntity<Order> getOrderById(int id) {
        return null;
    }
}
