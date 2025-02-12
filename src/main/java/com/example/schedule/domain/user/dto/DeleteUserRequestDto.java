package com.example.schedule.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DeleteUserRequestDto {
    @NotBlank
    private final String password;

    public DeleteUserRequestDto(String password) {
        this.password = password;
    }
}
