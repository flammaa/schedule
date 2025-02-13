package com.example.schedule.domain.comment.entity;

import com.example.schedule.domain.schedule.entity.Schedule;
import com.example.schedule.domain.user.entity.User;
import com.example.schedule.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheduleId", nullable = false)
    private Schedule schedule;

    public Comment(String comment, User user, Schedule schedule) {
        this.comment = comment;
        this.user = user;
        this.schedule = schedule;
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

}
