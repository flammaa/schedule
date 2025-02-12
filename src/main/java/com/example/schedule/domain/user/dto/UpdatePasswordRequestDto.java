package com.example.schedule.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdatePasswordRequestDto {

    @NotBlank(message = "필수 입력입니다.")
    private final String oldPassword;

    @NotBlank(message = "필수 입력입니다.")
    private final String newPassword;

    public UpdatePasswordRequestDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
