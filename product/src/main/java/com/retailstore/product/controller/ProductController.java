package com.retailstore.product.controller;

import com.retailstore.product.entity.Product;
import com.retailstore.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/health")
    public String health() {
        return "Hey I am fine";
    }
    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return (ResponseEntity<Product>) productService.addProduct(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable("id") long id){
        return productService.updateProduct(id,product);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<?> searchProduct(@PathVariable("id") long id){
        return productService.searchProduct(id);
    }
    @DeleteMapping("products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id){
        return productService.deleteProduct(id);
    }
//    POST
///api/products/
//
//
//    DELETE46
///api/products/{id}
//
//
//    PUT
///api/products/{id}
//
//
//    GET
///api/products/{id}

}
