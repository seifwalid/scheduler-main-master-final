package com.spring.scheduler.scheduler.service.Impl;

import com.spring.scheduler.scheduler.exception.ResourceNotFoundException;
import com.spring.scheduler.scheduler.model.TimeSlots;
import com.spring.scheduler.scheduler.repository.TeamRepository;
import com.spring.scheduler.scheduler.repository.TimeSlotsRepository;
import com.spring.scheduler.scheduler.service.TimeSlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeSlotServiceImpl implements TimeSlotsService {

    @Autowired
    private TimeSlotsRepository timeSlotsRepository;
    @Override
    public TimeSlots getTimeSlotById(long id) {
        return timeSlotsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TimeSlot", "id", id));
    }
}
