package com.example.ex19.board.dto;

import com.example.ex19.member.entity.Member;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
public class BoardUpdateDto {
    @Positive(message = "잘못된 경로 입니다.")
    private Long id;

    @NotEmpty(message = "제목은 필수 입력입니다.")
    private String title;

    @NotEmpty(message = "제목은 필수 입력입니다.")
    private String content;

    private String wbnonce;

//    @AssertFalse : false 값만 통과 가능
//    @AssertTrue : true 값만 통과 가능
//    @DecimalMax(value=) : 지정된 값 이하의 실수만 통과 가능
//    @DecimalMin(value=) : 지정된 값 이상의 실수만 통과 가능
//    @Digits(integer=,fraction=) : 대상 수가 지정된 정수와 소수 자리수보다 적을 경우 통과 가능
//    @Email
//    @Future : 대상 날짜가 현재보다 미래일 경우만 통과 가능
//    @Past : 대상 날짜가 현재보다 과거일 경우만 통과 가능
//    @Max(value) : 지정된 값보다 아래일 경우만 통과 가능
//    @Min(value) : 지정된 값보다 이상일 경우만 통과 가능
//    @Negative // 음수만 허용
//    @NegativeOrZero // 음수와 0만 허용
//    @NotNull : null 값이 아닐 경우만 통과 가능
//    @NotEmpty : null, "" 이 아닌 경우
//    @NotBlank : null, "", " " 이 아닌 경우
//    @Null : null 일 경우만 통과 가능
//    @Pattern(regex=, flag=, message=) : 해당 정규식을 만족할 경우만 통과 가능
//    @Positive // 양수만 허용
//    @PositiveOrZero // 양수와 0만 허용
//    @Size(min=, max=) : 문자열 또는 배열이 지정된 값 사이일 경우 통과 가능
}
