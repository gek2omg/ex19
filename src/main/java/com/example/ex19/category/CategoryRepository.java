package com.example.ex19.category;


import com.example.ex19.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CategoryRepository extends JpaRepository<Category, Integer>,
        QuerydslPredicateExecutor<Category>, CategoryRepositoryCustom {



}
