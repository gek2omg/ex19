package com.example.ex19.category;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;


public class CategoryRepositoryImpl implements CategoryRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public CategoryRepositoryImpl(EntityManager em) {

        this.jpaQueryFactory = new JPAQueryFactory(em);
    }


}
