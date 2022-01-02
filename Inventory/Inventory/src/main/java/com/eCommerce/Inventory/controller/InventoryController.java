package com.eCommerce.Inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.Inventory.entity.Inventory;
import com.eCommerce.Inventory.service.InventoryService;

@RestController
@RequestMapping("/inv")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/testrun")
	public String getMessage() {
		return "Hum bol rahe";
	}
	
	// ADD Inventory
	@PostMapping("/")
	public ResponseEntity<Inventory> addinventory(@RequestBody Inventory inventory) {
	return (ResponseEntity<Inventory>) inventoryService.createInventory(inventory);
	} 
		
//	// SEARCH Inventory | by Inventory Id
//	@GetMapping("/{inventoryId}")
//	public ResponseEntity<?> searchByInventoryId(@PathVariable("inventoryId") int inventoryId) {
//	ResponseEntity<?> response = inventoryService.getinventoryByInventoryId(inventoryId);
//	return response;
//	}
//
//	// SEARCH Inventory | by Product Id
//	@GetMapping("/{productId}")
//	public ResponseEntity<?> searchByProductId(@PathVariable("productId") int productId) {
//	ResponseEntity<?> response = inventoryService.getinventoryByProductId(productId);
//	return response;
//	}
//	
//	// SEARCH Inventories | by Categories
//	@GetMapping("/{Category}")
//	public ResponseEntity<?> searchByCategory(@PathVariable("inventoryId") String category) {
//	ResponseEntity<?> response = inventoryService.getInventoriesByCategory(category);
//	return response;
//	}
//
//	// UPDATE Inventory | By Inventory Id
//	@PutMapping("/{inventoryId}/{quantity}")
//	public ResponseEntity<?> updateByInventoryId(@PathVariable("inventoryId") int inventoryId,@PathVariable("quantity") int quantity) {
//	ResponseEntity<?> response = inventoryService.updateInventoryByInventoryId(inventoryId,quantity);
//	return response;
//	}	
//	
//	// UPDATE Inventory | By Product Id
//	@PutMapping("/{productId}/{quantity}")
//	public ResponseEntity<?> updateByProductId(@PathVariable("productId") int productId,@PathVariable("quantity") int quantity) {
//	ResponseEntity<?> response = inventoryService.updateInventoryByProductId( productId,quantity);
//	return response;
//	}	
//	
//	
//	// PURGE Inventory
//	@DeleteMapping("/{productId}")
//	public ResponseEntity<?> purgeByProductId(@PathVariable("productId") int productId) {
//	ResponseEntity<?> response = inventoryService.deleteInventoryByProductId(productId);
//	return response;
//	}
//	
//	// PURGE Inventories
//	@DeleteMapping("/{category}")
//	public ResponseEntity<?> purgeByCategory(@PathVariable("productId") String category) {
//	ResponseEntity<?> response = inventoryService.deleteInventoriesByCategory(category);
//	return response;
//	}
}
