package com.eCommerce.Inventory.service;

import java.util.List;
// import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.eCommerce.Inventory.entity.Inventory;

public interface InventoryService {

	ResponseEntity<?> createInventory(Inventory inventory);

	ResponseEntity<?> searchInventory(int productId);
  
	ResponseEntity<?> alterInventory(int productId, int quantity);

	ResponseEntity<?> deleteInventory(int productId);

	ResponseEntity<?> searchAllInventory();



}
