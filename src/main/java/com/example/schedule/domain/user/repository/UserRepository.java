package com.example.schedule.domain.user.repository;

import com.example.schedule.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    default User findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Does not exist id = " + id)
                );
    }

    Optional<User> findByEmail(String email); //option genereric user

    //교안내용
    //     public Long findByEmailAndPassword(String email, String password); {
//         return USERS.Stream()
//                 .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
//                 .map(User::getId)
//                 .findFirst()
//                 .orElse(null);
//    }
}