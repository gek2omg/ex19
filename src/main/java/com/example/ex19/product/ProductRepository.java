package com.example.ex19.product;

import com.example.ex19.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>,
        QuerydslPredicateExecutor<Product>, ProductRepositoryCustom {



    @Modifying(clearAutomatically = true)
    @Query("UPDATE Product p SET p.price = :price WHERE p.id = :id ")
    int updateProductPrice(@Param(value="price") Integer price, @Param(value="id") Integer id);
}
