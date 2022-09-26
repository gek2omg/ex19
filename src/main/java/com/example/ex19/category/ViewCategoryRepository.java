package com.example.ex19.category;

import com.example.ex19.category.entity.CategoryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ViewCategoryRepository extends JpaRepository<CategoryView, Integer>,
        QuerydslPredicateExecutor<CategoryView>, ViewCategoryRepositoryCustom {



}
