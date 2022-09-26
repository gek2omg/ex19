package com.example.ex19.category;

import com.example.ex19.category.dto.CategoryViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewCategoryService {

    private final ViewCategoryRepository viewCategoryRepository;

    public List<CategoryViewDto> searchFindAll() {

        return viewCategoryRepository.searchFindAll();
    }


    public List<CategoryViewDto> searchFindAllParentId(Integer parent_id) {


        return viewCategoryRepository.searchFindAllByParentId(parent_id);
    }

}
