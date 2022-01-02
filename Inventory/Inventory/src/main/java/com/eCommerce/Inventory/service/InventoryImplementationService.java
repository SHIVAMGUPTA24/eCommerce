package com.eCommerce.Inventory.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eCommerce.Inventory.dao.InventoryRepository;
import com.eCommerce.Inventory.entity.Inventory;
import com.eCommerce.Inventory.exception.BadDataException;

@Service
@Transactional
public class InventoryImplementationService implements InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepo;

	@Override
	public  ResponseEntity<?> createInventory(Inventory inventory) throws BadDataException { 
		if(inventory.getProductId()==0) {
			throw new BadDataException("Nothing Provided | Empty Request");
		}
		return new ResponseEntity<Inventory>(inventoryRepo.save(inventory),HttpStatus.CREATED);
	}
	
	
//	 User puser = userrepo.findById(id)
//             .orElseThrow(()->new ResourceNotFoundException("User with ID :"+id+" Not Found!"));

	
//
//	@Override
//	public ResponseEntity<?> getinventoryByInventoryId(int inventoryId) {
//		return new ResponseEntity<Inventory>(inventoryRepo.findByInventoryId(inventoryId),HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<?> getinventoryByProductId(int productId) {
//		return new ResponseEntity<Inventory>(inventoryRepo.findByProductId(productId),HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<?> getInventoriesByCategory(String category) {
//		return new ResponseEntity<List<Inventory>>(inventoryRepo.findByCategory(category),HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<?> updateInventoryByInventoryId(int inventoryId, int quantity) {
//		Inventory inventory = inventoryRepo.findByInventoryId(inventoryId);
//		return new ResponseEntity<Inventory>(inventoryRepo.save(inventory),HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<?> updateInventoryByProductId(int productId, int quantity) {
//		Inventory inventory = inventoryRepo.findByProductId(productId);
//		return new ResponseEntity<Inventory>(inventoryRepo.save(inventory),HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<?> deleteInventoryByProductId(int productId) {
//		inventoryRepo.deleteById(inventoryRepo.findByProductId(productId).getInventoryId());
//	}
//
//	@Override
//	public ResponseEntity<?> deleteInventoriesByCategory(String category) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}