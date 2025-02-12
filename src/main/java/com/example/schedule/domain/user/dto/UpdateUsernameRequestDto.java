package com.example.schedule.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateUsernameRequestDto {
    @NotBlank(message = "필수 입력입니다.")
    private final String verifyPassword;

    @NotBlank(message = "필수 입력입니다.")
    private final String newUsername;

    public UpdateUsernameRequestDto(String verifyPassword, String newUsername) {
        this.verifyPassword = verifyPassword;
        this.newUsername = newUsername;

    }
}
