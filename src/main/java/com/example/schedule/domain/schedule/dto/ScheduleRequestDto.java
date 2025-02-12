package com.example.schedule.domain.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    @NotBlank(message = "필수 입력입니다.")
    private final String title;

    private final String contents;


    public ScheduleRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }


}
