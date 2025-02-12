package com.example.schedule.domain.login.dto;

import com.example.schedule.domain.user.entity.User;
import lombok.Getter;

@Getter
public class LoginResponseDto {
    private final Long userId;
    private final String username;
    private final String email;

    public LoginResponseDto(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }
}
