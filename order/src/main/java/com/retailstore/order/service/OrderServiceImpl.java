package com.retailstore.order.service;

import com.retailstore.order.entity.LineItem;
import com.retailstore.order.entity.Order;
import com.retailstore.order.exception.OrderNotFoundException;
import com.retailstore.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepo;

    @Override
    public ResponseEntity<?> getOrderById(int id) {
        Optional<Order> orderById = orderRepo.findById(id);
        if (!orderById.isPresent()) {
            throw new OrderNotFoundException("There is no order with this order id please check your order id!");
        }
        return new ResponseEntity<>(orderById, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createOrder(Order order) {
        ResponseEntity<?> response = new ResponseEntity<>(orderRepo.save(order), HttpStatus.CREATED);
        return response;
    }

    @Override
    public ResponseEntity<?> updateOrder(int id, Order order) {
        Optional<Order> findById = orderRepo.findById(id);
        if (!findById.isPresent()) {
            throw new OrderNotFoundException("There is no order with this order id please check your order id!");
        }
        return new ResponseEntity<>(orderRepo.save(order), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteOrder(int id) {
        Optional<Order> findById = orderRepo.findById(id);
        if (!findById.isPresent()) {
            throw new OrderNotFoundException("There is no order with this order id please check your order idi");
        }
        orderRepo.deleteById(id);
        return new ResponseEntity<>("Order is emptied", HttpStatus.OK);
    }
}
