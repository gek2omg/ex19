package com.example.ex19.board.dto;

import com.example.ex19.member.entity.Member;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BoardSaveDto {
    @NotEmpty(message = "제목은 필수 입력입니다.")
    private String title;
    private String content;
    private Member member;
}
