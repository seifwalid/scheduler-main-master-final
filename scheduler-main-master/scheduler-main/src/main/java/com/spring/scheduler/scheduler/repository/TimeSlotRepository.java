package com.spring.scheduler.scheduler.repository;

import com.spring.scheduler.scheduler.model.TimeSlots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<TimeSlots,Long> {
}
