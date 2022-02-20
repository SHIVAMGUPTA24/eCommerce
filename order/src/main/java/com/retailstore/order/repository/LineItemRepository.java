package com.retailstore.order.repository;

import com.retailstore.order.entity.OrdersLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



@Repository
public interface LineItemRepository extends JpaRepository<OrdersLineItem, Integer> {

    OrdersLineItem findByCustomerIdAndProductId(int customerId, int productId);

    public List<OrdersLineItem> findByCustomerId(int customerId);

    @Query("UPDATE OrdersLineItem l set l.quantity = ?1 WHERE l.customerId = ?2 AND l.productId = ?3")
    @Modifying
    public int updateQuantity(int quantity, int customerId, int productId);

    @Query("DELETE FROM OrdersLineItem l WHERE l.customerId = ?1 AND l.productId = ?2")
    @Modifying
    public int deleteByCustomerIdAndProductId(int customerId, int productId);

    @Query("DELETE FROM OrdersLineItem l WHERE l.customerId = ?1")
    @Modifying
    public void deleteAllByCustomerId(int customerId);

}
