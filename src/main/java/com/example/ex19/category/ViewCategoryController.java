package com.example.ex19.category;

import com.example.ex19.category.dto.CategoryViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class ViewCategoryController {

    private final ViewCategoryService viewCategoryService;

    @GetMapping("/API/category")
    @ResponseBody
    public List<CategoryViewDto> categoryAllAPI() {

        return viewCategoryService.searchFindAll();
    }


    @GetMapping("/API/category/{parent_id}")
    @ResponseBody
    public List<CategoryViewDto> categoryChildListAPI(@PathVariable("parent_id") Integer parent_id) {

        if(parent_id >= 0) {

        } else {
            parent_id = 0;
        }

        return viewCategoryService.searchFindAllParentId(parent_id);
    }

}
