package com.example.schedule.domain.user.dto;

import lombok.Getter;

@Getter
public class UpdateEmailRequestDto {
    private final String verifyPassword;

    private final String newEmail;

    public UpdateEmailRequestDto(String verifyPassword, String newEmail) {
        this.verifyPassword = verifyPassword;
        this.newEmail = newEmail;
    }
}
