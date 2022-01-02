package com.retailstore.product.service;

import com.retailstore.product.entity.Product;
import com.retailstore.product.exception.BadDataException;
import com.retailstore.product.exception.ProductNotFoundException;
import com.retailstore.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<?> addProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deleteProduct(long productId) {
        Optional<Product> entityToBeDeleted = productRepository.findById(productId);
        if (entityToBeDeleted.isEmpty())
            throw new ProductNotFoundException("No Product Found with this data");
//            return new ResponseEntity<>("No value Exist", HttpStatus.NOT_FOUND);
        productRepository.delete(entityToBeDeleted.get());
        return new ResponseEntity<>(entityToBeDeleted.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateProduct(long productId, Product product) {
        Optional<Product> entityToBeUpdated = productRepository.findById(productId);
        if (entityToBeUpdated.isEmpty()) {
            throw new ProductNotFoundException("No Product Found with this data:give valid data to be updated");
        }
        else {
                productRepository.updateProduct(productId,product.getProductDescription()
                        ,product.getProductName(),product.getProductPrice(),product.getProductType());
                ResponseEntity<?> updatedProduct = searchProduct(productId);
                return new ResponseEntity<>(updatedProduct.getBody(), HttpStatus.OK);

        }
    }

    @Override
    public ResponseEntity<?> searchProduct(long productId) {
        if(productId<0)
            throw new BadDataException("Negative id not allowed");
        Optional<Product> searchProductWithId = productRepository.findById(productId);
        if (searchProductWithId.isEmpty())
            throw new ProductNotFoundException("No Product Found with this data");
        return new ResponseEntity<>(searchProductWithId.get(), HttpStatus.OK);

    }

}
