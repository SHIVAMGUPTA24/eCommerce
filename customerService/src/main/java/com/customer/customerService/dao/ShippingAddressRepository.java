package com.customer.customerService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.customerService.entity.ShippingAddress;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer>{

	@Query("DELETE FROM ShippingAddress s WHERE s.sId = ?1")
	@Modifying
	public void deleteBySId(int sId);
	
}
