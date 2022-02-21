package com.eCommerce.Inventory.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eCommerce.Inventory.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	Optional<Inventory> findByProductId(int inventoryId);
	
//	@Query("update profile p set p.quantity = ?2 WHERE p.productId = ?1")
//	@Modifying
//	int update(int productId,int quantity);
	
	
}