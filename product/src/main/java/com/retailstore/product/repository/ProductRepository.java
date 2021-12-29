package com.retailstore.product.repository;

import com.retailstore.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Product p set p.productDescription= :productDescription ,  p.productName= :productName, p.productPrice=:productPrice,  p.productType= :productType where p.productId= :productId")
    public void updateProduct(@Param(value = "productId") long productId, @Param(value="productDescription") String productDescription,
                              @Param(value="productName")String productName, @Param(value="productPrice")double productPrice, @Param(value="productType")String productType);
}
