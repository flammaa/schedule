package com.example.schedule.domain.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DeleteScheduleRequestDto {
    @NotBlank
    private String password;
}
