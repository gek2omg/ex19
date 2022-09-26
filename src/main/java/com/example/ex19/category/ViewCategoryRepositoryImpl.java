package com.example.ex19.category;

import com.example.ex19.category.dto.CategoryViewDto;
import com.example.ex19.category.dto.QCategoryViewDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.ex19.category.entity.QCategoryView.categoryView;
import static org.springframework.util.StringUtils.hasText;


public class ViewCategoryRepositoryImpl implements ViewCategoryRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public ViewCategoryRepositoryImpl(EntityManager em) {

        this.jpaQueryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<CategoryViewDto> searchFindAll() {

        List<CategoryViewDto> content = jpaQueryFactory
                .select(new QCategoryViewDto(
                        categoryView.categoryId,
                        categoryView.parentId,
                        categoryView.name,
                        categoryView.pathChildIds,
                        categoryView.pathChildName,
                        categoryView.orderNum,
                        categoryView.depth,
                        categoryView.pathId,
                        categoryView.pathName
                ))
                .from(categoryView)
                .where(
                        categoryView.parentId.goe(0)
                )
                .fetch();

        return content;

    }

    @Override
    public List<CategoryViewDto> searchFindAllByParentId(Integer parent_id) {

        List<CategoryViewDto> content = jpaQueryFactory
                .select(new QCategoryViewDto(
                        categoryView.categoryId,
                        categoryView.parentId,
                        categoryView.name,
                        categoryView.pathChildIds,
                        categoryView.pathChildName,
                        categoryView.orderNum,
                        categoryView.depth,
                        categoryView.pathId,
                        categoryView.pathName
                ))
                .from(categoryView)
                .where(
                        searchFindAllByParentIdPredicate(parent_id)
                )
                .fetch();

        return content;
    }


    private BooleanBuilder searchFindAllByParentIdPredicate(Integer parent_id) {

        return new BooleanBuilder()
                .and(condParentId(parent_id));
    }


    private Predicate condParentId(Integer parent_id) {
        BooleanBuilder builder = new BooleanBuilder();
        if (parent_id >= 0) {
            builder.and(categoryView.parentId.in(parent_id));
        }

        return builder;
    }
}
