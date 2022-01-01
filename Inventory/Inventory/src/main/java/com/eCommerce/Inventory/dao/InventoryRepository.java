package com.eCommerce.Inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.Inventory.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
//	Inventory findByInventoryId(int inventoryId);
//
//	Inventory findByProductId(int productId);
//
//	List<Inventory> findByCategory(String category);	
}