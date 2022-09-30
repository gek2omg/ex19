package com.example.ex19.product;


import com.example.ex19.common.CustomValidationField;
import com.example.ex19.product.dto.ProductSaveDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product/form")
    public String productForm(Model model, ProductSaveDto productSaveDto) {

        model.addAttribute("productSaveDto", productSaveDto);

        return "product";
    }


    @PostMapping("/product/form_proc")
    @ResponseBody
    public ObjectNode productFormProc(@Validated @ModelAttribute ProductSaveDto productSaveDto,
                                  BindingResult bindingResult) throws JsonProcessingException {

        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        List<FieldError> errors = bindingResult.getFieldErrors();

        if(bindingResult.hasErrors()) {
            objectNode
                    .put("code", "400")
                    .put("message", "ERROR")
                    .putPOJO("info", CustomValidationField.reBuildErrors(errors));
            return objectNode;


//            System.out.println(bindingResult);
//            System.out.println(bindingResult.getTarget());
//            System.out.println("ajax 처리 : error " + bindingResult.getObjectName());
//            return "";
        }

        Integer product_id = productService.saveProductV1 (productSaveDto);

        objectNode
                .put("code", 200)
                .put("message", "SUCCESS")
                .put("location", "/tenant/product/list");

        return objectNode;
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
        private String msg;
    }



}