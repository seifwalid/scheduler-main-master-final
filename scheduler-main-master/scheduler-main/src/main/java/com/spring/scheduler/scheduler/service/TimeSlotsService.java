package com.spring.scheduler.scheduler.service;

import com.spring.scheduler.scheduler.model.Match;
import com.spring.scheduler.scheduler.model.Team;
import com.spring.scheduler.scheduler.model.TimeSlots;

import java.util.List;

public interface TimeSlotsService {
    TimeSlots getTimeSlotById(long id);

    public List<TimeSlots> getAllslots();


}
