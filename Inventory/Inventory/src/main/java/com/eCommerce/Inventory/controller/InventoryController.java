package com.eCommerce.Inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.Inventory.service.InventoryService;

@RestController
@RequestMapping("/inv")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/get")
	public String getMessage() {
		return "I'm fine thankyou";
	}
//	
//	// SEARCH LINE ITEM
//	@GetMapping("/{inventoryId}/{productId}")
//	public ResponseEntity<?> searchinventory(@PathVariable("inventoryId") int inventoryId, @PathVariable("productId") int productId) {
//	ResponseEntity<?> response = inventoryService.getinventoryByInventoryAndProductId(inventoryId, productId);
//	return response;
//	}
//
//	// ADD LINE ITEM
//	@PostMapping("/")
//	public ResponseEntity<?> addinventory(@RequestBody Inventory inventory) {
//	ResponseEntity<?> response = inventoryService.createInventory(inventory);
//	return response;
//	}
//
//	// UPDATE LINE ITEM
//	@PutMapping("/{quantity}/{productId}/{inventoryId}")
//	public ResponseEntity<?> updateinventory(@PathVariable("quantity") int quantity,
//	@PathVariable("productId") int productId, @PathVariable("inventoryId") int inventoryId) {
//	ResponseEntity<?> response = inventoryService.updateInventory(quantity, productId, inventoryId);
//	return response;
//	}
//
//	// DELETE LINE ITEM
//	@DeleteMapping("/{productId}/{inventoryId}")
//	public ResponseEntity<?> deleteinventory(@PathVariable("productId") int productId,
//	@PathVariable("inventoryId") int inventoryId) {
//	ResponseEntity<?> response = inventoryService.deleteInventory(productId, inventoryId);
//	return response;
//	}
}
