package com.example.schedule.domain.login.controller;

import com.example.schedule.common.Const;
import com.example.schedule.domain.login.dto.LoginResponseDto;
import com.example.schedule.domain.user.dto.UserResponseDto;
import com.example.schedule.domain.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SessionUserController {

    private final UserService userService;

    @PostMapping("/session-login")
    public String login(
            @Valid @ModelAttribute LoginResponseDto dto,
            HttpServletResponse request
    ) {
        LoginResponseDto responseDto = userService.login(dto.getEmail(), dto.getPassword());
        Long userId = responseDto.getId();

        // 실패시 예외처리
        if (userId == null) {
            return "session-login";
        }

        // 로그인 성공시 로직
        // Session의 Default Value는 true이다.
        // Session이 request에 존재하면 기존의 Session을 반환하고,
        // Session이 request에 없을 경우에 새로 Session을 생성한다.
        HttpSession session = request.getSession();

        // 회원 정보 조회
        UserResponseDto loginUser = userService.findById(userId);

        // Session에 로그인 회원 정보를 저장한다.
        session.setAttribute(Const.LOGIN_USER, loginUser);

        // 로그인 성공시 리다이렉트
        return "redirect:/session-home";
    }

    @PostMapping("/session-logout")
    public String logout(HttpServletRequest request) {
        // 로그인하지 않으면 HttpSession이 null로 반환된다.
        HttpSession session = request.getSession(false);
        // 세션이 존재하면 -> 로그인이 된 경우
        if(session != null) {
            session.invalidate(); // 해당 세션(데이터)을 삭제한다.
        }

        return "redirect:/session-home";
    }

}
