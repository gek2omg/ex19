package com.example.ex19.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;

@Data
public class BoardSearchDto {

    private String title;
    private String content;

}
