package com.example.ex19.category;

import com.example.ex19.category.dto.CategoryViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ViewCategoryRepository viewCategoryRepository;



}
