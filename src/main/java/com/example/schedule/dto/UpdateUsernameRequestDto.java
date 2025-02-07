package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class UpdateUsernameRequestDto {

    private final String verifyPassword;

    private final String newUsername;

    public UpdateUsernameRequestDto(String verifyPassword, String newUsername) {
        this.verifyPassword = verifyPassword;
        this.newUsername = newUsername;

    }
}
