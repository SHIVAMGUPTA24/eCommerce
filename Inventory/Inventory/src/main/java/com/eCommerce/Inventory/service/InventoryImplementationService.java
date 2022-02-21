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
	InventoryRepository repo;

	public ResponseEntity<?> createInventory(Inventory inventory)
	{
		
		ResponseEntity<?> response;
		if(inventory.getProductId()<=0)
			{
				throw new BadDataException("________BAD DATA__________");
			}
		else if(!repo.findByProductId(inventory.getProductId()).isEmpty()) {
				throw new RedundantDataException
				("___PRODUCT EXISTS |  product already exists with an inventory_____");
			}
		else
			{
				Inventory inv=new Inventory();
				inv.setProductId(inventory.getProductId());
				inv.setQuantity(inventory.getQuantity());
				response = new ResponseEntity<Inventory>(repo.save(inv),HttpStatus.CREATED);	
			}
		return response;
	}

	@Override
	public ResponseEntity<?> searchInventory(int productId) {
		ResponseEntity<?> response;
		Inventory inv=repo.findByProductId(productId).orElseThrow
				(() -> new InventoryNotFoundException
				("_______Oops no inventory exists by that product________"));
		response=new ResponseEntity<Inventory>(inv,HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<?> alterInventory(int productId,int quantity) {
		ResponseEntity<?> response;
		Inventory inv=repo.findByProductId(productId).get();
		if(productId<=0)
			{
				throw new BadDataException("________BAD DATA__________");
			}
		else if(quantity<0
						&&repo.findByProductId(productId).isEmpty()
						&&repo.findByProductId(productId).get().getQuantity()!=quantity) {
					inv.setProductId(productId);
					inv.setQuantity(repo.findByProductId(productId).get().getQuantity()-quantity);
					if(inv.getQuantity()<0){
						throw new BadDataException("Out of stock");
					}
					response=new ResponseEntity<Inventory>(repo.save(inv),HttpStatus.ACCEPTED);
			}
		else{
					inv.setProductId(productId);
					inv.setQuantity(repo.findByProductId(productId).get().getQuantity()+quantity);
					response=new ResponseEntity<Inventory>(repo.save(inv),HttpStatus.ACCEPTED);	
			}
		return response;
	}

	@Override
	public ResponseEntity<?> deleteInventory(int productId) {
		if(repo.findByProductId(productId).isPresent()) {
			repo.deleteById(repo.findByProductId(productId).get().getInventoryId());
		}else {
			throw new InventoryNotFoundException("Inventory you trying to remove does not exists");
		}
		return new ResponseEntity<String>(
				repo.findByProductId(productId).isPresent()?"deletion failed":"deletion successful"
				,HttpStatus.OK
				);
	}

	@Override
	public ResponseEntity<?> searchAllInventory() {
		ResponseEntity<?> res=new ResponseEntity<List<Inventory>>(repo.findAll(),HttpStatus.ACCEPTED);
		return res;
	}
	
}