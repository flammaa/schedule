package com.example.schedule.domain.login.dto;

import com.example.schedule.domain.user.entity.User;
import lombok.Getter;

@Getter
public class LoginResponseDto {
    private final Long id;
    private final String username;
    private final String email;

    public LoginResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }
}
