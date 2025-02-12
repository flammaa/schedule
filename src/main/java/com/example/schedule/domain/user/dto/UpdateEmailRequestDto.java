package com.example.schedule.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateEmailRequestDto {
    @NotBlank(message = "필수 입력입니다.")
    private final String verifyPassword;

    @NotBlank(message = "필수 입력입니다.")
    private final String newEmail;

    public UpdateEmailRequestDto(String verifyPassword, String newEmail) {
        this.verifyPassword = verifyPassword;
        this.newEmail = newEmail;
    }
}
