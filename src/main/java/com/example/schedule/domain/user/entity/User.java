package com.example.schedule.domain.user.entity;

import com.example.schedule.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true) //이름 필수, 유일
    private String username;

    @Column(nullable = false, unique = true) // 필수, 유일 //!! 이메일 형식에 대한 제어를 해야하지 않나?
    private String email;

    @Column(nullable = false, unique = true) // 필수, 유일
    private String password;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateUsername(String username) {
        this.username = username;
    }

    public void updateEmail(String email) {
        this.email = email;
    }


}
