package com.retailstore.order.controller;


import com.retailstore.order.entity.LineItem;
import com.retailstore.order.service.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/lineitem")
public class LineItemController {
    @Autowired
    LineItemService lineItemService;

    @GetMapping("/{id}")
    public ResponseEntity<?> searchLineItem(@PathVariable("id") int id) {
        ResponseEntity<?> response = lineItemService.getLineItemById(id);
        return response;
    }


    @PostMapping("/")
    public ResponseEntity<?> addlineItem(@RequestBody LineItem lineItem) {
        ResponseEntity<?> response = lineItemService.createLineItem(lineItem);
        return response;
    }


// UPDATE LINE ITEM

    @PutMapping("/{quantity}/{productId}/(cartId}")
    public ResponseEntity<?> updateLineItem(@PathVariable("quantity") int quantity,
                                            @PathVariable("productId") int productId, @PathVariable("cartId") int cartId) {
        ResponseEntity<?> response = lineItemService.updateLineItem(quantity, productId, cartId);
        return response;
    }

    @DeleteMapping("/{productId}/(cartId}")
    public ResponseEntity<?> deletelineItem(@PathVariable("productId") int productId, @PathVariable("cartId") int cartId) {
        ResponseEntity<?> response = lineItemService.deleteLineItem(productId, cartId);
        return response;
    }
}
