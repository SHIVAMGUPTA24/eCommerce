package com.customer.customerService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.customerService.entity.BillingAddress;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Integer>{

	@Query("DELETE FROM BillingAddress b WHERE b.bId = ?1")
	@Modifying
	public void deleteByBId(int bId);
	
}
