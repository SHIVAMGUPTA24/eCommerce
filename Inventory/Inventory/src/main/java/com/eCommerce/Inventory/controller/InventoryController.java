package com.eCommerce.Inventory.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/test")
	public String getApiCall(){
		return "API Called";
	}
	
	@GetMapping("/testrun")
	public ResponseEntity<?> getAllInventories(){
		return inventoryService.getAllInventories();
	}
	
	// ADD Inventory
		@PostMapping("/create")
		public ResponseEntity<?> addinventory(@RequestBody Inventory inventory) {
		return inventoryService.createInventory(inventory);
	} 
	
//	// ADD Inventory
//		@PostMapping("/create-all")
//		public ResponseEntity<?> addinventory(@RequestBody List<Inventory> invList) {
//		return inventoryService.createAllInventories(invList);
//	} 
		
//	[{
//	    "productId" : 1006,
//	    "category" : "mobiles",
//	    "quantity" : 20 
//	},
//	{
//	    "productId" : 1007,
//	    "category" : "mobiles",
//	    "quantity" : 30 
//	},
//	{
//	    "productId" : 1008,
//	    "category" : "mobiles",
//	    "quantity" : 40 
//	}]
		
	// SEARCH Inventory | by Inventory Id
	@GetMapping("/findby/invid/{inventoryid}")
	public ResponseEntity<?> searchByInventoryId(@PathVariable("inventoryid") UUID inventoryId) {
	return inventoryService.getByInventoryId(inventoryId);
	}
//
	// SEARCH Inventory | by Product Id
	@GetMapping("/findby/prdctid/{productid}")
	public ResponseEntity<?> searchByProductId(@PathVariable("productid") int productId) {
	ResponseEntity<?> response = inventoryService.getinventoryByProductId(productId);
	return response;
	}
	
////	 SEARCH Inventories | by Type
//	@GetMapping("/findby/{type}")
//	public ResponseEntity<?> searchByCategory(@PathVariable("type") String type) {
//	ResponseEntity<List<Inventory>> response = inventoryService.getInventoriesByCategory(type);
//	return response;
//	}

	// UPDATE Inventory | By Inventory Id
	@PutMapping("/updateforinv/{inventoryid}/{quantity}")
	public ResponseEntity<?> updateByInventoryId(@PathVariable("inventoryid") UUID inventoryId,@PathVariable("quantity") int quantity) {
	ResponseEntity<?> response = inventoryService.updateInventoryByInventoryId(inventoryId,quantity);
	return response;
	}	
	
	// UPDATE Inventory | By Product Id
	@PutMapping("/updateforprdct/{productid}/{quantity}")
	public ResponseEntity<?> updateByProductId(@PathVariable("productid") int productId,@PathVariable("quantity") int quantity) {
	ResponseEntity<?> response = inventoryService.updateInventoryByProductId( productId,quantity);
	return response;
	}	
	
	
	// PURGE Inventory
	@DeleteMapping("/deletefor/{productid}")
	public ResponseEntity<?> purgeByProductId(@PathVariable("productid") int productId) {
	ResponseEntity<?> response = inventoryService.deleteInventoryByProductId(productId);
	return response;
	}
	
	// PURGE Inventories
//	@DeleteMapping("/deletefor/{category}")
//	public ResponseEntity<?> purgeByCategory(@PathVariable("productId") String category) {
//	ResponseEntity<?> response = inventoryService.deleteInventoriesByCategory(category);
//	return response;
//	}
}
