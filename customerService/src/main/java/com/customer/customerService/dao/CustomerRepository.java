package com.customer.customerService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.customerService.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	/*
	 	public LineItem findByCustomerIdAndProductId(int customerId, int productId);
	
	public List<LineItem> findByCustomerId(int customerId);

	@Query("UPDATE LineItem l set l.quantity = ?1 WHERE l.customerId = ?2 AND l.productId = ?3")
	@Modifying
	public int updateQuantity(int quantity, int customerId, int productId);

	@Query("DELETE FROM LineItem l WHERE l.customerId = ?1 AND l.productId = ?2")
	@Modifying
	public int deleteByCustomerIdAndProductId(int customerId, int productId);
	
	@Query("DELETE FROM LineItem l WHERE l.customerId = ?1")
	@Modifying
	public void deleteAllByCustomerId(int customerId);
	 */
}
