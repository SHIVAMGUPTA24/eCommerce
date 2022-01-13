package com.eCommerce.Inventory.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eCommerce.Inventory.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
//	public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	public Optional<Inventory> findByProductId(int productId);

//	@Query("UPDATE Inventory l set l.quantity = ?1 WHERE l.inventoryId = ?2")
//	@Modifying
//	public int updateQuantity(int quantity, int inventoryId);


	@Query("delete Inventory i WHERE i.productId = ?1")
	@Modifying
	public Integer deleteByProductId(int productId);

//	@Query("select Inventory i WHERE i.type = ?1")
//	@Modifying
//	List<Inventory> findByCategory(String category);	
}