package com.example.ex19.category.entity;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@Table(name = "view_category")
public class CategoryView {
    @Id
    private Integer categoryId;

    private Integer parentId;

    private String name;

    private String pathChildIds;

    private String pathChildName;

    private Integer orderNum;

    private Integer depth;

    private String pathId;

    private String pathName;

    @QueryProjection
    public CategoryView(Integer categoryId, Integer parentId, String name, String pathChildIds, String pathChildName, Integer orderNum, Integer depth, String pathId, String pathName) {
        this.categoryId = categoryId;
        this.parentId = parentId;
        this.name = name;
        this.pathChildIds = pathChildIds;
        this.pathChildName = pathChildName;
        this.orderNum = orderNum;
        this.depth = depth;
        this.pathId = pathId;
        this.pathName = pathName;
    }
}
