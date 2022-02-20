package com.retailstore.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersLineItem {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    private int productId;
    private String productName;
    private int quantity;
    private double price;
    private int customerId;

}
