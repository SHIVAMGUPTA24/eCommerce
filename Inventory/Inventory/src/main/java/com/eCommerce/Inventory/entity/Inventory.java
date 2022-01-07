package com.eCommerce.Inventory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int inventoryId;
	private int productId;
	private String type;
	private int quantity;
	
}
