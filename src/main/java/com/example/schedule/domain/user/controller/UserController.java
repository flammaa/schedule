package com.example.schedule.domain.user.controller;

import com.example.schedule.domain.user.dto.*;
import com.example.schedule.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
        SignUpResponseDto signUpResponseDto =
                userService.signUp(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword()
                );
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> FindById(@PathVariable Long userId) {

        UserResponseDto userResponseDto = userService.findById(userId);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/users/password/{userId}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long userId,
            @RequestBody UpdatePasswordRequestDto requestDto
            ) {
        userService.updatePassword(userId, requestDto.getOldPassword(), requestDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/users/username/{userId}")
    public ResponseEntity<Void> updateUsername(
            @PathVariable Long userId,
            @RequestBody UpdateUsernameRequestDto requestDto
    ) {
        userService.updateUsername(userId, requestDto.getVerifyPassword(), requestDto.getNewUsername());

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/users/email/{userId}")
    public ResponseEntity<Void> updateEmail(
            @PathVariable Long userId,
            @RequestBody UpdateEmailRequestDto requestDto
    ) {
        userService.updateEmail(userId, requestDto.getVerifyPassword(), requestDto.getNewEmail());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId) {

        userService.delete(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
