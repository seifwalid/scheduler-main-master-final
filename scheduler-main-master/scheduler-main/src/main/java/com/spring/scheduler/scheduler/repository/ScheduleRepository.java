package com.spring.scheduler.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.scheduler.scheduler.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
