package com.retailstore.product.service;

import com.retailstore.product.entity.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<?> addProduct(Product product);
    ResponseEntity<?> deleteProduct(long productId);
    ResponseEntity<?> updateProduct(long productId,Product product);
    ResponseEntity<?> searchProduct(long productId);
}
