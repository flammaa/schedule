package com.example.schedule.controller;

import com.example.schedule.dto.*;
import com.example.schedule.service.UserService;
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

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> FindById(@PathVariable Long id) {

        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/users/password/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto requestDto
            ) {
        userService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/users/username/{id}")
    public ResponseEntity<Void> updateUsername(
            @PathVariable Long id,
            @RequestBody UpdateUsernameRequestDto requestDto
    ) {
        userService.updateUsername(id, requestDto.getVerifyPassword(), requestDto.getNewUsername());

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/users/email/{id}")
    public ResponseEntity<Void> updateEmail(
            @PathVariable Long id,
            @RequestBody UpdateEmailRequestDto requestDto
    ) {
        userService.updateEmail(id, requestDto.getVerifyPassword(), requestDto.getNewEmail());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
