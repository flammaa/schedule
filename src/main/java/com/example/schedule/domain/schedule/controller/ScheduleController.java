package com.example.schedule.domain.schedule.controller;

import com.example.schedule.domain.schedule.dto.ScheduleRequestDto;
import com.example.schedule.domain.schedule.dto.ScheduleResponseDto;
import com.example.schedule.domain.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping()
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getTitle(), requestDto.getContents(), requestDto.getUserId);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

}
