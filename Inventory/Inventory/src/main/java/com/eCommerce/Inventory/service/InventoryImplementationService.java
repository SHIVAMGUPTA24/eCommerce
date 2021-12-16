package com.eCommerce.Inventory.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCommerce.Inventory.dao.InventoryRepository;

@Service
@Transactional
public class InventoryImplementationService implements InventoryService {
	
	@Autowired
	InventoryRepository InventoryRepo;

//	@Override
//	public ResponseEntity<?> getInventoryById(int id) {
//		
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<?> getInventoryByCustomerAndProductId(int customerId, int productId) {
//		
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<?> createInventory(Inventory Inventory) {
//		
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<?> updateInventory(int quantity, int productId, int customerId) {
//		
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<?> deleteInventory(int productId, int customerId) {
//		
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<?> getinventoryByInventoryAndProductId(int inventoryId, int productId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}