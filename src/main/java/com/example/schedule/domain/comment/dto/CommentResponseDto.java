package com.example.schedule.domain.comment.dto;

import com.example.schedule.domain.comment.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private final Long commentId;
    private final String comment;
    private final Long userId;
    private final Long scheduleId;



    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.comment = comment.getComment();
        this.userId = comment.getUser().getUserId();
        this.scheduleId = comment.getSchedule().getScheduleId();
    }



}
