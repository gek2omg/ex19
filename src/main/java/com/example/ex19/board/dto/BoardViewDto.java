package com.example.ex19.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class BoardViewDto {

    private Long id;

    private String title;

    private String content;

    private String memberName;

    @QueryProjection
    public BoardViewDto(Long id, String title, String content, String memberName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberName = memberName;
    }
}
