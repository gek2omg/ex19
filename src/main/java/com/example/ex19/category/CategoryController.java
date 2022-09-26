package com.example.ex19.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


}
