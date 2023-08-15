package com.spring.scheduler.scheduler.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.scheduler.scheduler.model.Schedule;
import com.spring.scheduler.scheduler.model.ScheduleType;
import com.spring.scheduler.scheduler.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

	private ScheduleService scheduleService;

	public ScheduleController(ScheduleService scheduleService) {
		super();
		this.scheduleService = scheduleService;
	}

	@GetMapping("/getSchedule/{id}")
	public ResponseEntity<Schedule> getSchedule(@PathVariable("id") long id) {
		return new ResponseEntity<Schedule>(scheduleService.getSchedule(id), HttpStatus.OK);
	}

	@GetMapping("/getAllSchedules")
	public List<Schedule> getAllSchedules() {
		return scheduleService.getAllSchedules();
	}

	@GetMapping("/getScheduleByType/{type}")
	public List<Schedule> getScheduleByType(@PathVariable("type") ScheduleType type) {
		return scheduleService.getSchedulesByType(type);
	}

	@DeleteMapping("/deleteSchedule/{id}")
	public void deleteSchedule(@PathVariable("id") long id) {
		scheduleService.deleteSchedule(id);
	}

	@PostMapping("/saveSchedule")
	public ResponseEntity<Schedule> saveSchedule(@RequestBody Schedule schedule) {
		return new ResponseEntity<Schedule>(scheduleService.saveSchedule(schedule), HttpStatus.CREATED);
	}

	@PutMapping("/updateSchedule/{id}")
	public ResponseEntity<Schedule> updateSchedule(@RequestBody Schedule schedule, @PathVariable("id") long id) {
		return new ResponseEntity<Schedule>(scheduleService.updateSchedule(schedule, id), HttpStatus.OK);
	}
	
	@GetMapping("/setSchedule/{id}")
	public ResponseEntity<Schedule> setSchedule(@RequestBody long id){
		return new ResponseEntity<Schedule>(scheduleService.setSchedule(id), HttpStatus.CREATED);
	}

}
