package com.example.schedule.domain.schedule.dto;

import com.example.schedule.domain.schedule.entity.Schedule;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long scheduleId;
    private final String title;
    private final String contents;
    private final Long userId;


    public ScheduleResponseDto(Long scheduleId, String title, String contents, Long userId) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.contents = contents;
        this.userId = userId;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getScheduleId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getUser() != null ? schedule.getUser().getUserId() : null
        );
    }






}
