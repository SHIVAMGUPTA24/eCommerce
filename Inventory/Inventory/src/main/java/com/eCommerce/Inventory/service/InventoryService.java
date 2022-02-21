package com.eCommerce.Inventory.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.eCommerce.Inventory.entity.Inventory;

public interface InventoryService {

	ResponseEntity<?> createInventory(Inventory inventory);

	ResponseEntity<?> searchInventory(int inventoryId);

	ResponseEntity<?> alterInventory(int inventoryId, int quantity);

	ResponseEntity<?> deleteInventory(int inventoryId);

	ResponseEntity<?> searchAllInventory();


}
