package com.retailstore.order.repository;

import com.retailstore.order.entity.LineItem;
import com.retailstore.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem,Integer> {
    LineItem findByOrderAndProductId(Order order, int productId);

    void updateQuantity(int quantity, int productId, int orderId);

    void deleteByOrderAndProductId(int productId, int orderId);
}
