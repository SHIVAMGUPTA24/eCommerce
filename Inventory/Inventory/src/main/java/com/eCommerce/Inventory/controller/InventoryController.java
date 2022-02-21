package com.eCommerce.Inventory.controller;

import java.util.List;
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
@RequestMapping("/api/inventory")
public class InventoryController {

	@Autowired
	InventoryService serv;
	
	@PostMapping("/")
	public ResponseEntity<?> addInventory(@RequestBody Inventory inventory)
	{
		ResponseEntity<?> response=serv.createInventory(inventory);
		return response;
	}
	
	@GetMapping("/find/{inventoryId}")
	public ResponseEntity<?> findInventory(@PathVariable int inventoryId)
	{
		ResponseEntity<?> response=serv.searchInventory(inventoryId);
		return response;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAllInventories()
	{
		ResponseEntity<?> response=serv.searchAllInventory();
		return response;
	}

	@PutMapping("/update/{inventoryId}/{quantity}")
	public ResponseEntity<?> updateInventory(@PathVariable int inventoryId,@PathVariable int quantity)
	{
		ResponseEntity<?> response=serv.alterInventory(inventoryId,quantity);
		return response;

	@DeleteMapping("/remove/{inventoryId}")
	public ResponseEntity<?> removeInventory(@PathVariable int inventoryId)
	{
		ResponseEntity<?> response=serv.deleteInventory(inventoryId);
		return response;
	}
}