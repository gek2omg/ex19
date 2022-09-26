package com.example.ex19.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProductSaveDto {
    private Integer price;

    private String name;

    private String selectCategory;

}
