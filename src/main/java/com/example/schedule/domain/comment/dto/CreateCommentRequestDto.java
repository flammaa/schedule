package com.example.schedule.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateCommentRequestDto {

    @NotBlank(message = "필수 입력입니다.")
    private final String comment;

    @NotNull(message = "유효한 값이 아닙니다.")
    private final Long scheduleId;


    public CreateCommentRequestDto(String comment, Long scheduleId) {
        this.comment = comment;
        this.scheduleId = scheduleId;
    }
}
