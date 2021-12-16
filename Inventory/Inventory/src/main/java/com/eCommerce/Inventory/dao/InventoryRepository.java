package com.eCommerce.Inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.Inventory.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

//	public Inventory findByCustomerIdAndProductId(int customerId, int productId);
//	
//	public List<Inventory> findByCustomerId(int customerId);
//
////	@Query("UPDATE Inventory l set l.quantity = ?1 WHERE l.productId = ?2 AND l.customerId = ?3")
////	@Modifying
//	public void updateQuantity(int quantity, int productId, int customerId);
//
////	@Query("DELETE FROM Inventory l WHERE l.productId = ?1 AND l.customerId = ?2")
////	@Modifying
//	public void deleteByCustomerIdAndProductId(int productId, int customerId);
//	
}