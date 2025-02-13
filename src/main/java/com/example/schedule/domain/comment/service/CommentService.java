package com.example.schedule.domain.comment.service;

import com.example.schedule.domain.comment.dto.CommentResponseDto;
import com.example.schedule.domain.comment.entity.Comment;
import com.example.schedule.domain.comment.repository.CommentRepository;
import com.example.schedule.domain.schedule.entity.Schedule;
import com.example.schedule.domain.schedule.repository.ScheduleRepository;
import com.example.schedule.domain.user.entity.User;
import com.example.schedule.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;


    public CommentResponseDto save(String comment, Schedule schedule, User user) {

        Comment newcomment = new Comment(comment, user, schedule);
        Comment savedComment = commentRepository.save(newcomment);

        return new CommentResponseDto(savedComment);
    }
}
