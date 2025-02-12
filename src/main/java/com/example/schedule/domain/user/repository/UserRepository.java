package com.example.schedule.domain.user.repository;

import com.example.schedule.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    default User findByIdOrElseThrow(Long userId) {
        return findById(userId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Does not exist id = " + userId)
                );
    }

    Optional<User> findByEmail(String email); //option genereric user

    Long userId(Long userId);

    //교안내용
    //     public Long findByEmailAndPassword(String email, String password); {
//         return USERS.Stream()
//                 .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
//                 .map(User::getId)
//                 .findFirst()
//                 .orElse(null);
//    }
}