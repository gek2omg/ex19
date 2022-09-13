package com.example.ex19.member.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
public class MemberSaveDto {


    @NotEmpty(message = "이름은 필수 입력입니다.")
    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = true, length = 13)
    private String jumin;

    private String address;
}
