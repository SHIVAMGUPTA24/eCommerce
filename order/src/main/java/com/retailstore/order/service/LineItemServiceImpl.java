package com.retailstore.order.service;

import com.retailstore.order.entity.LineItem;
import com.retailstore.order.entity.Order;
import com.retailstore.order.exception.BadDataException;
import com.retailstore.order.exception.OrderNotFoundException;
import com.retailstore.order.repository.LineItemRepository;
import com.retailstore.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class LineItemServiceImpl implements LineItemService {
    @Autowired
    OrderRepository orderRepo;
    @Autowired
    LineItemRepository lineItemRepo;

    @Override
    public ResponseEntity<?> getLineItemById(int id) {
        Optional<LineItem> findById = lineItemRepo.findById(id);
        if (!findById.isPresent ())
            throw new OrderNotFoundException("There is no line item with this line item id please check your line item id!");
        return new ResponseEntity<> (findById, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createLineItem(LineItem lineItem) {
            int addedQuantity = lineItem.getQuantity();
            if (addedQuantity <= 0) {
                throw new BadDataException("Quantity cannot be less than 1");
            }
            LineItem item = lineItemRepo.findByOrderAndProductId(lineItem.getOrder(), lineItem.getProductId());
            if (item != null) {
                addedQuantity = item.getQuantity() + lineItem.getQuantity();
                item.setQuantity(addedQuantity);
            } else {
                item = lineItem;
            }
                return new ResponseEntity<>(lineItemRepo.save(item), HttpStatus.CREATED);
            }

    @Override
    public ResponseEntity<?> updateLineItem(int quantity, int productId, int orderId) {
        Optional<Order> findById= orderRepo.findById(orderId);
        if (!findById.isPresent()) {
            throw new OrderNotFoundException("Order with this id doesn't exists");
        }
        if (quantity <= 0) {
            throw new BadDataException ("Quantity cannot be less than 1");
        }
        lineItemRepo.updateQuantity(quantity, productId, orderId);
        return new ResponseEntity<>("Line Item updated", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteLineItem(int productId, int orderId) {
        Optional<Order> findById= orderRepo.findById(orderId);
        if (!findById.isPresent()) {
            throw new OrderNotFoundException ("Order with this id doesn't exists");
        }
        lineItemRepo.deleteByOrderAndProductId(productId, orderId);
        return new ResponseEntity<>("Line Item is deleted", HttpStatus.OK);
    }


}



