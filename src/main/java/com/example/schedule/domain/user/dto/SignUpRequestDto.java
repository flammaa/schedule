package com.example.schedule.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignUpRequestDto {
    @NotBlank(message = "필수 입력입니다.")
    private final String username;

    @NotBlank(message = "필수 입력입니다.")
    @Email(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞춰주세요.")
    private final String email;

    @NotBlank(message = "필수 입력입니다.")
    private final String password;

    public SignUpRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
