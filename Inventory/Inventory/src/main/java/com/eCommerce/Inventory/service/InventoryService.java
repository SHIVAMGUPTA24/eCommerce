package com.eCommerce.Inventory.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.eCommerce.Inventory.entity.Inventory;

public interface InventoryService {

	ResponseEntity<?> createInventory(Inventory inventory);

	ResponseEntity<?> getByInventoryId(UUID inventoryId);

	ResponseEntity<?> getinventoryByProductId(int productId);

	ResponseEntity<?> getInventoriesByCategory(String type);

	ResponseEntity<?> updateInventoryByInventoryId(UUID inventoryId, int quantity);

	ResponseEntity<?> updateInventoryByProductId(int productId, int quantity);

	ResponseEntity<?> deleteInventoryByProductId(int productId);

	ResponseEntity<?> deleteInventoriesByCategory(String category);

	ResponseEntity<?> getAllInventories();

//	ResponseEntity<?> createAllInventories(List<Inventory> invList);


}
