package com.example.ex19.board.api;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class BoardListApiDto {
    private Long id;

    private String title;

    private String memberName;

    @QueryProjection
    public BoardListApiDto(Long id, String title, String memberName) {
        this.id = id;
        this.title = title;
        this.memberName = memberName;
    }
}
