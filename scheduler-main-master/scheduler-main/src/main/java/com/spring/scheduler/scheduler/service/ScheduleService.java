package com.spring.scheduler.scheduler.service;

import java.util.List;

import com.spring.scheduler.scheduler.exception.ResourceNotFoundException;
import com.spring.scheduler.scheduler.model.Schedule;
import com.spring.scheduler.scheduler.model.ScheduleType;
import com.spring.scheduler.scheduler.model.Team;

public interface ScheduleService {

	Schedule saveSchedule(Schedule schedule);

	Schedule getSchedule(long id);

	List<Schedule> getAllSchedules();

	Schedule updateSchedule(Schedule schedule, long id);

	void deleteSchedule(long id);

	List<Schedule> getSchedulesByType(ScheduleType scheduleType);

	Schedule getScheduleById(Long id);

	Schedule setSchedule(long id);
}
