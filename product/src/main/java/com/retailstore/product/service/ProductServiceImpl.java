package com.retailstore.product.service;

import com.retailstore.product.entity.Product;
import com.retailstore.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<?> addProduct(Product product) {
        Product savedProduct=productRepository.save(product);
        return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deleteProduct(long productId) {
        Optional<Product> entityToBeDeleted=productRepository.findById(productId);
        if(entityToBeDeleted.isEmpty())
            return new ResponseEntity<>("No value Exist",HttpStatus.NOT_FOUND);
        productRepository.delete(entityToBeDeleted.get());
        return new ResponseEntity<>(entityToBeDeleted.get(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateProduct(Product product) {
        Optional<Product> entityToBeUpdated=productRepository.findById(product.getProductId());
        if(entityToBeUpdated.isEmpty())
        {return new ResponseEntity<>("No value Exist",HttpStatus.NOT_FOUND);}
        else{
            Product updatedProduct = productRepository.save(product);
            return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> searchProduct(long productId) {
        Optional<Product> searchProductWithId=productRepository.findById(productId);
        if(searchProductWithId.isEmpty())
            return new ResponseEntity<>("No value Exist",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(searchProductWithId.get(),HttpStatus.OK);

    }
}
