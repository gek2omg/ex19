package com.example.ex19.product;

import com.example.ex19.product.dto.ProductSaveDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product/form")
    public String productForm() {

        return "product";
    }


    @PostMapping("/product/form_proc")
    @ResponseBody
    public Result productFormProc(ProductSaveDto productSaveDto) throws JsonProcessingException {

        Integer product_id = productService.saveProductV1 (productSaveDto);

        return new Result(productSaveDto, "SUCCESS");
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
        private String msg;
    }



}