package com.cart.cartService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LineItem {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	private int productId;
	private String productName;
	private int quantity;
	private double price;
	private int customerId;
	
}
