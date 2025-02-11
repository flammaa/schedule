package com.example.schedule.domain.login.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private final Long id;
    private final String username;
    private final String email;


    public LoginResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
