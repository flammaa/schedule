package com.example.schedule.domain.schedule.controller;

import com.example.schedule.domain.schedule.dto.DeleteScheduleRequestDto;
import com.example.schedule.domain.schedule.dto.ScheduleRequestDto;
import com.example.schedule.domain.schedule.dto.ScheduleResponseDto;
import com.example.schedule.domain.schedule.dto.UpdateScheduleRequestDto;
import com.example.schedule.domain.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/{userId}")
    public ResponseEntity<ScheduleResponseDto> save(
            @PathVariable Long userId,
            @RequestBody ScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        userId
                );

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<ScheduleResponseDto>> getSchedulesByUserEmail(
            @PathVariable String email) {
        List<ScheduleResponseDto> schedules = scheduleService.getSchedulesByUserEmail(email);

        return ResponseEntity.ok(schedules);
    }

    @PatchMapping("/{scheduleId}")
    public ResponseEntity<Void> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleRequestDto requestDto
    ) {
        scheduleService.updateSchedule(
                scheduleId,
                requestDto.getPassword(),
                requestDto.getNewTitle(),
                requestDto.getNewContents()
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long scheduleId,
            @RequestBody DeleteScheduleRequestDto requestDto
    ) {
        scheduleService.deleteSchedule(scheduleId, requestDto.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
