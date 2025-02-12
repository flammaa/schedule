package com.example.schedule.domain.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    @NotBlank(message = "필수 입력입니다.")
    private final String password;

    @NotBlank(message = "필수 입력입니다.")
    private final String newTitle;

    @NotBlank(message = "필수 입력입니다.")
    private final String newContents;


    public UpdateScheduleRequestDto(String password, String newTitle, String newContents) {
        this.password = password;
        this.newTitle = newTitle;
        this.newContents = newContents;
    }
}
