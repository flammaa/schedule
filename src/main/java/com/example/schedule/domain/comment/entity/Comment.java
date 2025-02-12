package com.example.schedule.domain.comment.entity;

import com.example.schedule.domain.schedule.entity.Schedule;
import com.example.schedule.domain.user.entity.User;
import com.example.schedule.global.entity.BaseEntity;
import jakarta.persistence.*;
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
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;






}
//- [ ]  생성한 일정에 댓글을 남길 수 있습니다.
//    - [ ]  댓글과 일정은 연관관계를 가집니다. →  `3주차 연관관계 매핑 참고!`
//- [ ]  댓글을 저장, 조회, 수정, 삭제할 수 있습니다.
//- [ ]  댓글은 아래와 같은 필드를 가집니다.
//    - [ ]  `댓글 내용`, `작성일`, `수정일`, `유저 고유 식별자`, `일정 고유 식별자` 필드
//    - [ ]  `작성일`, `수정일` 필드는 `JPA Auditing`을 활용하여 적용합니다.
//
//###