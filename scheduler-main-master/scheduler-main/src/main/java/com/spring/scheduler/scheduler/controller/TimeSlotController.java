package com.spring.scheduler.scheduler.controller;

import com.spring.scheduler.scheduler.model.Match;
import com.spring.scheduler.scheduler.model.TimeSlots;
import com.spring.scheduler.scheduler.service.MatchService;
import com.spring.scheduler.scheduler.service.TimeSlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/time_slot")
public class TimeSlotController  {

    @Autowired
    private TimeSlotsService timeSlotsService;

    public TimeSlotController() {


    }
    public TimeSlotController(TimeSlotsService timeSlotsService) {
        this.timeSlotsService = timeSlotsService;

    }
    @GetMapping("/slots")
    public List<TimeSlots> slotsList() {
        return timeSlotsService.getAllslots();
    }



}
