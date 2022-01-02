package com.eCommerce.Inventory.service;

import org.springframework.http.ResponseEntity;

import com.eCommerce.Inventory.entity.Inventory;

public interface InventoryService {

	ResponseEntity<?> createInventory(Inventory inventory);

//	ResponseEntity<?> getinventoryByInventoryId(int inventoryId);
//
//	ResponseEntity<?> getinventoryByProductId(int productId);
//
//	ResponseEntity<?> getInventoriesByCategory(String category);
//
//	ResponseEntity<?> updateInventoryByInventoryId(int inventoryId, int quantity);
//
//	ResponseEntity<?> updateInventoryByProductId(int productId, int quantity);
//
//	ResponseEntity<?> deleteInventoryByProductId(int productId);
//
//	ResponseEntity<?> deleteInventoriesByCategory(String category);

}
