package com.example.ex19.form.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class FormSaveDto {

    private String productTitle;

//    private List<SelectCategory> selectCategory;

    private String selectCategory;

    @Data
    @AllArgsConstructor
    static class SelectCategory {
        private String cid1;
        private String cname1;

        private String cid2;
        private String cname2;
    }

}
