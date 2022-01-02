package com.retailstore.order.controller;

import com.retailstore.order.entity.Order;
import com.retailstore.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order/health")
    public String health() {
        return "Hey I am fine";
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrders(@PathVariable("id") int id) {
        ResponseEntity<Order> response =orderService.getOrderById(id);
        return response;
    }

    @PostMapping("/order")
    public ResponseEntity<?> postOrder(@RequestBody Order order){
        return null;
    }

///api/order
///api/order/{id}
///api/order/{id}
///api/order/{id}







}
