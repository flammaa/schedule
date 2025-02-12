package com.example.schedule.domain.login.service;

import com.example.schedule.domain.login.dto.LoginResponseDto;
import com.example.schedule.domain.user.dto.UserResponseDto;
import com.example.schedule.domain.user.entity.User;
import com.example.schedule.domain.user.repository.UserRepository;
import com.example.schedule.global.config.PasswordEncoder;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public LoginResponseDto login(String email, String password) {
        User findUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 이메일을 가진 사용자가 존재하지 않습니다."));

        if(!passwordEncoder.matches(password, findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다."); //로그인 시 이메일과 비밀번호가 일치하지 않을 경우 HTTP Status code 401을 반환합니다.
        }
        return new LoginResponseDto(findUser);
    }


//        Long index = userRepository.findByEmailAndPassword(email, password);

//        return new LoginResponseDto(index);




//        User findUser = userRepository.findByEmail(email).orElseThrow(
//                () -> new IllegalArgumentException("해당 ")
//
//        );
//
//        if(!password.matches(loginRequestDto.getPassword))
//    }

    //참고용
//    @Transactional
//    public void updateEmail(Long id, String verifyPassword, String newEmail) {
//        User findUser = userRepository.findByIdOrElseThrow(id);
//
//        if(!findUser.getPassword().equals(verifyPassword)) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
//        }
//        findUser.updateEmail(newEmail);
//    }
}
