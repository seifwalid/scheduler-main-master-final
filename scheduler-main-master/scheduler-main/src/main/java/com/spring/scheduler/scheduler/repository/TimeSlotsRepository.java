package com.spring.scheduler.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.scheduler.scheduler.model.TimeSlots;

public interface TimeSlotsRepository extends JpaRepository<TimeSlots, Long> {

}
