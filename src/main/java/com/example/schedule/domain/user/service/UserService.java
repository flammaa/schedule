package com.example.schedule.domain.user.service;

import com.example.schedule.domain.user.dto.SignUpResponseDto;
import com.example.schedule.domain.user.dto.UserResponseDto;
import com.example.schedule.domain.user.entity.User;
import com.example.schedule.domain.user.repository.UserRepository;
import com.example.schedule.global.config.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignUpResponseDto signUp(String username, String email, String password) {

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(username, email, encodedPassword);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getUserId(), savedUser.getUsername(), savedUser.getEmail());
    }

    @Transactional(readOnly=true)
    public UserResponseDto findById(Long userId) {

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + userId);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUsername(), findUser.getEmail());
    }

    @Transactional
    public void updatePassword(Long userId, String oldPassword, String newPassword) {
        User findUser = userRepository.findByIdOrElseThrow(userId);

        if(!passwordEncoder.matches(oldPassword, findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        findUser.updatePassword(newPassword);
    }
    @Transactional
    public void updateUsername(Long userId, String verifyPassword, String newUsername) {
        User findUser = userRepository.findByIdOrElseThrow(userId);

        if(!passwordEncoder.matches(verifyPassword, findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        findUser.updateUsername(newUsername);
    }

    @Transactional
    public void updateEmail(Long userId, String verifyPassword, String newEmail) {
        User findUser = userRepository.findByIdOrElseThrow(userId);

        if(!passwordEncoder.matches(verifyPassword, findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        findUser.updateEmail(newEmail);
    }

    @Transactional
    public void delete(Long userId, @NotBlank String password) {

        User findUser = userRepository.findByIdOrElseThrow(userId);
        if(!passwordEncoder.matches(password, findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        userRepository.delete(findUser);
    }



}
