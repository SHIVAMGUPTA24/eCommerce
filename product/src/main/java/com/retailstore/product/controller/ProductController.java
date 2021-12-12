package com.retailstore.product.controller;

import com.retailstore.product.entity.Product;
import com.retailstore.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return (ResponseEntity<Product>) productService.addProduct(product);
    }

    @GetMapping("/product/{id}")


}
