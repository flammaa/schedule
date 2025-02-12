package com.example.schedule.domain.schedule.service;

import com.example.schedule.domain.schedule.dto.ScheduleResponseDto;
import com.example.schedule.domain.schedule.repository.ScheduleRepository;
import com.example.schedule.domain.user.entity.User;
import com.example.schedule.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String title, String contents, Long userId) {

        User findUser = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        );

        return null;
    }
}
