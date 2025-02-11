package com.example.schedule.domain.login.controller;

import com.example.schedule.domain.login.dto.LoginRequestDto;
import com.example.schedule.domain.login.dto.LoginResponseDto;
import com.example.schedule.domain.login.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto requestDto) {
        LoginResponseDto loginResponseDto =
                loginService.login(requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }

}
