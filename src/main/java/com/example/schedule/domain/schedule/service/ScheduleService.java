package com.example.schedule.domain.schedule.service;

import com.example.schedule.domain.schedule.dto.ScheduleResponseDto;
import com.example.schedule.domain.schedule.entity.Schedule;
import com.example.schedule.domain.schedule.repository.ScheduleRepository;
import com.example.schedule.domain.user.entity.User;
import com.example.schedule.domain.user.repository.UserRepository;
import com.example.schedule.global.config.PasswordEncoder;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;
    private final PasswordEncoder passwordEncoder;

    public ScheduleResponseDto save(String title, String contents, Long userId) {

        User findUser = userRepository.findByUserId(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        );

        Schedule schedule = new Schedule(title, contents);
        schedule.setUser(findUser);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                schedule.getScheduleId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getUser().getUserId());
    }
    @Transactional
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }
    @Transactional
    public List<ScheduleResponseDto> getSchedulesByUserEmail(String email) {
        List<Schedule> schedules = scheduleRepository.findByUserEmail(email);
        return schedules.stream()
                .map(ScheduleResponseDto::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateSchedule(Long scheduleId, String password, String newTitle, String newContents) {
        Schedule findSchedule = scheduleRepository.findByScheduleId(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 스케줄 ID가 존재하지 않습니다. ID: " + scheduleId));

        User scheduleUser = findSchedule.getUser();
        if (!passwordEncoder.matches(password, scheduleUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        findSchedule.updateSchedule(newTitle, newContents);


    }
    @Transactional
    public void deleteSchedule(Long scheduleId, @NotBlank String password) {
        Schedule findSchedule = scheduleRepository.findByScheduleId(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 스케줄 ID가 존재하지 않습니다. ID: " + scheduleId));

        User scheduleUser = findSchedule.getUser();
        if (!passwordEncoder.matches(password, scheduleUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        scheduleRepository.delete(findSchedule);
    }
}
