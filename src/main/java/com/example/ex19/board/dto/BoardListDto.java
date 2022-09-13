package com.example.ex19.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class BoardListDto {
    private Long id;

    private String title;

    private String memberName;

    @QueryProjection
    public BoardListDto(Long id, String title, String memberName) {
        this.id = id;
        this.title = title;
        this.memberName = memberName;
    }
}
