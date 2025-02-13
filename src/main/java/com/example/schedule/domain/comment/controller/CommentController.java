package com.example.schedule.domain.comment.controller;

import com.example.schedule.domain.comment.dto.CommentResponseDto;
import com.example.schedule.domain.comment.dto.CreateCommentRequestDto;
import com.example.schedule.domain.comment.entity.Comment;
import com.example.schedule.domain.comment.service.CommentService;
import com.example.schedule.domain.schedule.entity.Schedule;
import com.example.schedule.domain.schedule.repository.ScheduleRepository;
import com.example.schedule.domain.user.entity.User;
import com.example.schedule.domain.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules/{scheduleId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    @PostMapping
    public ResponseEntity<CommentResponseDto> save(
            @PathVariable Long scheduleId,
            @Valid @RequestBody CreateCommentRequestDto requestDto,
            HttpServletRequest session) {

        Long userId = (Long) session.getAttribute("userId");
        System.out.println("Session userId: " + userId);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // 401 Unauthorized
        }

        User user = userRepository.findById(userId).
                orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다"));

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));

        CommentResponseDto commentResponseDto = commentService.save(
                requestDto.getComment(),
                schedule,
                user
        );

        return new ResponseEntity<>(commentResponseDto, HttpStatus.CREATED);
    }

}
