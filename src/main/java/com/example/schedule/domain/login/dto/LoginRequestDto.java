package com.example.schedule.domain.login.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequestDto {

    @NotBlank(message = "필수 입력입니다.")
    private final String email;

    @NotBlank(message = "필수 입력입니다.")
    private final String password;

}
