package com.example.ex19.product;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public ProductRepositoryImpl(EntityManager em) {

        this.jpaQueryFactory = new JPAQueryFactory(em);
    }



}
