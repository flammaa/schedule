package com.example.schedule.domain.schedule.repository;

import com.example.schedule.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s WHERE s.user.email = :email")
    List<Schedule> findByUserEmail(@Param("email") String email); //이메일 기준으로 스케쥴 조회

    Optional<Schedule> findByScheduleId(Long scheduleId);

}
