package com.example.schedule.domain.schedule.entity;

import com.example.schedule.domain.user.entity.User;
import com.example.schedule.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    public Schedule() {
    }

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    //작성자 추가
    public void setUser(User user) {
        this.user = user;
    }


    public void updateSchedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
