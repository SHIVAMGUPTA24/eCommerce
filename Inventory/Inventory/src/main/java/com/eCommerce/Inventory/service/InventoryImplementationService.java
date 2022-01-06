package com.eCommerce.Inventory.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eCommerce.Inventory.dao.InventoryRepository;
import com.eCommerce.Inventory.entity.Inventory;
import com.eCommerce.Inventory.exception.BadDataException;
import com.eCommerce.Inventory.exception.InventoryNotFoundException;
import com.eCommerce.Inventory.exception.RedundantDataException;

@Service
@Transactional
public class InventoryImplementationService implements InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepo;

	@Override
	public  ResponseEntity<?> createInventory(Inventory inventory){ 
//		if(inventory.getCategory())
		try {
			return new ResponseEntity<Inventory>(inventoryRepo.save(inventory),HttpStatus.CREATED);
		}catch (Exception e) {
			throw new BadDataException(e.getMessage());
		}
	}
	
	
//
	@Override
	public ResponseEntity<?> getByInventoryId(int inventoryId) {
		Inventory inv = inventoryRepo.findById(inventoryId).orElseThrow(()->new InventoryNotFoundException("Inventory Not Found For InventoryId: "+inventoryId));
		ResponseEntity<?> res=new ResponseEntity<Inventory>(inv,HttpStatus.OK);
		return res;
	}


	@Override
	public ResponseEntity<?> getinventoryByProductId(int productId) {
		Inventory inv = inventoryRepo.findByProductId(productId).orElseThrow(()->new InventoryNotFoundException("Inventory Not Found For ProductId: "+productId));
		ResponseEntity<?> res=new ResponseEntity<Inventory>(inv,HttpStatus.OK);
		return res;
	}


//	@Override
//	public ResponseEntity<?> getInventoriesByCategory(String category) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	@Override
	public ResponseEntity<?> updateInventoryByInventoryId(int inventoryId, int quantity) {
		Inventory inv = inventoryRepo.findById(inventoryId).orElseThrow(()->new InventoryNotFoundException("Inventory Not Found For InventoryId: "+inventoryId));
		if (quantity <= 0) {
			throw new BadDataException("Quantity cannot be less than 1");
		}
		inv.setQuantity(quantity);
		return new ResponseEntity<Inventory>(inventoryRepo.save(inv), HttpStatus.OK);
	}


	@Override
	public ResponseEntity<?> updateInventoryByProductId(int productId, int quantity) {
		Inventory inv = inventoryRepo.findByProductId(productId).orElseThrow(()->new InventoryNotFoundException("Inventory Not Found For ProductId: "+productId));
		if (quantity <= 0) {
			throw new BadDataException("Quantity cannot be less than 1");
		}
		inv.setQuantity(quantity);
		return new ResponseEntity<Inventory>(inventoryRepo.save(inv), HttpStatus.OK);
	}


	@Override
	public ResponseEntity<?> deleteInventoryByProductId(int productId) {
		Inventory inv = inventoryRepo.findByProductId(productId).orElseThrow(()->new InventoryNotFoundException("Inventory Not Found For ProductId: "+productId));
		int ret=0;
		ret=inventoryRepo.deleteByProductId(productId);
		if(ret!=1){
			throw new RedundantDataException("redundant data");
		}
		return new ResponseEntity<String>("Deleted",HttpStatus.ACCEPTED);
	}


	@Override
	public ResponseEntity<?> getInventoriesByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseEntity<?> deleteInventoriesByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ResponseEntity<List<Inventory>> getAllInventories() {
		List<Inventory> invlist=inventoryRepo.findAll();
		
		return new ResponseEntity<List<Inventory>>(invlist,HttpStatus.OK);
	}
	
	


}