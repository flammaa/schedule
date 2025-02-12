package com.example.schedule.domain.login.controller;

import com.example.schedule.domain.login.common.Const;
import com.example.schedule.domain.login.dto.LoginRequestDto;
import com.example.schedule.domain.login.dto.LoginResponseDto;
import com.example.schedule.domain.login.service.LoginService;
import com.example.schedule.domain.user.dto.UserResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginRequestDto dto,
            HttpServletRequest request
    ) {
        LoginResponseDto responseDto = loginService.login(dto.getEmail(), dto.getPassword());
        Long userId = responseDto.getUserId();

        // 실패시 401 UNAUTHORIZED 응답 반환
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // 로그인 성공시 로직
        // Session의 Default Value는 true이다.
        // Session이 request에 존재하면 기존의 Session을 반환하고,
        // Session이 request에 없을 경우에 새로 Session을 생성한다.
        HttpSession session = request.getSession();

        // Session에 로그인 회원 정보를 저장한다.
        session.setAttribute(Const.LOGIN_USER, responseDto.getUserId());

        // 로그인 성공시
        return ResponseEntity.ok(responseDto);

    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            HttpServletRequest request
    ) {
        // 로그인하지 않으면 HttpSession이 null로 반환된다.
        HttpSession session = request.getSession(false);
        // 세션이 존재하면 -> 로그인이 된 경우
        if(session != null) {
            session.invalidate(); // 해당 세션(데이터)을 삭제한다.
        }
        return ResponseEntity.ok("로그아웃 성공");
    }




//    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto requestDto) {
//        LoginResponseDto loginResponseDto =
//                loginService.login(requestDto.getEmail(), requestDto.getPassword());
//
//        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
//    }

}
