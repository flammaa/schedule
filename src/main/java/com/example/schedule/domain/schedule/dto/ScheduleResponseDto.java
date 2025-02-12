package com.example.schedule.domain.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long scheduleId;
    private final Long userId;
    private final String title;
    private final String contents;


    public ScheduleResponseDto(Long scheduleId, Long userId, String title, String contents) {
        this.scheduleId = scheduleId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }
}
