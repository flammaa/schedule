package com.example.schedule.service;

import com.example.schedule.dto.SignUpResponseDto;
import com.example.schedule.dto.UserResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;



    public SignUpResponseDto signUp(String username, String email, String password) {
        User user = new User(username, email, password);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    public UserResponseDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUsername(), findUser.getEmail());
    }

    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        User findUser = userRepository.findByIdOrElseThrow(id);

        if(!findUser.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        findUser.updatePassword(newPassword);
    }
    @Transactional
    public void updateUsername(Long id, String verifyPassword, String newUsername) {
        User findUser = userRepository.findByIdOrElseThrow(id);

        if(!findUser.getPassword().equals(verifyPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        findUser.updateUsername(newUsername);
    }

    @Transactional
    public void updateEmail(Long id, String verifyPassword, String newEmail) {
        User findUser = userRepository.findByIdOrElseThrow(id);

        if(!findUser.getPassword().equals(verifyPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        findUser.updateEmail(newEmail);
    }

    public void delete(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }
}
