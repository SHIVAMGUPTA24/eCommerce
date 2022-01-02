package com.retailstore.order.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name="order_id")
    @JsonBackReference
    private Order order;

}
