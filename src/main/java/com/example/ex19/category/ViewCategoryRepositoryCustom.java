package com.example.ex19.category;

import com.example.ex19.category.dto.CategoryViewDto;

import java.util.List;

public interface ViewCategoryRepositoryCustom {

    List<CategoryViewDto> searchFindAll();
    List<CategoryViewDto> searchFindAllByParentId(Integer parent_id);
}
