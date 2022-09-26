package com.example.ex19.product;

import com.example.ex19.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>,
        QuerydslPredicateExecutor<Product>, ProductRepositoryCustom {



}
