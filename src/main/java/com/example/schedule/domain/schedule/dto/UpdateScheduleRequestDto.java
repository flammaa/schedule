package com.example.schedule.domain.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    @NotBlank
    private final String password;

    @NotBlank
    private final String newTitle;

    @NotBlank
    private final String newContents;


    public UpdateScheduleRequestDto(String password, String newTitle, String newContents) {
        this.password = password;
        this.newTitle = newTitle;
        this.newContents = newContents;
    }
}
