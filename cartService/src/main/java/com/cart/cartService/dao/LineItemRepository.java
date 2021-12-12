package com.cart.cartService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cart.cartService.entity.LineItem;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Integer> {

	public LineItem findByCustomerIdAndProductId(int customerId, int productId);
	
	public List<LineItem> findByCustomerId(int customerId);

	@Query("UPDATE LineItem l set l.quantity = ?1 WHERE l.productId = ?2 AND l.customerId = ?3")
	@Modifying
	public void updateQuantity(int quantity, int productId, int customerId);

	@Query("DELETE FROM LineItem l WHERE l.productId = ?1 AND l.customerId = ?2")
	@Modifying
	public void deleteByCustomerIdAndProductId(int productId, int customerId);
	
}
