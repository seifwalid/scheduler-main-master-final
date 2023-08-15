package com.spring.scheduler.scheduler.service.Impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

import com.spring.scheduler.scheduler.exception.ResourceNotFoundException;
import com.spring.scheduler.scheduler.model.Match;
import com.spring.scheduler.scheduler.model.Schedule;
import com.spring.scheduler.scheduler.model.ScheduleType;
import com.spring.scheduler.scheduler.model.Team;
import com.spring.scheduler.scheduler.model.TimeSlots;
import com.spring.scheduler.scheduler.repository.MatchRepository;
import com.spring.scheduler.scheduler.repository.ScheduleRepository;
import com.spring.scheduler.scheduler.repository.TeamRepository;
import com.spring.scheduler.scheduler.repository.TimeSlotsRepository;
import com.spring.scheduler.scheduler.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	static final int minDaysBetweenMatches = 5;
	HashMap<String, Boolean> stadiums = new HashMap<String, Boolean>();

	private ScheduleRepository scheduleRepository;
	
	private TimeSlotsRepository timeSlotsRepository;
	
	private MatchRepository matchRepository;
	
	private TeamRepository teamRepository;

	public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
		super();
		this.scheduleRepository = scheduleRepository;
	}

	@Override
	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	@Override
	public Schedule getSchedule(long id) {
		Schedule exitstingSchedule = scheduleRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Schedule", "ID", id));
		return exitstingSchedule;
	}

	@Override
	public List<Schedule> getAllSchedules() {
		return scheduleRepository.findAll();
	}

	@Override
	public Schedule updateSchedule(Schedule schedule, long id) {
		Schedule exitstingSchedule = scheduleRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Schedule", "ID", id));
		exitstingSchedule.setName(schedule.getName());
		exitstingSchedule.setScheduleType(schedule.getScheduleType());
		exitstingSchedule.setStartDate(schedule.getStartDate());
		exitstingSchedule.setEndDate(schedule.getEndDate());
		exitstingSchedule.setMatchesList(schedule.getMatchesList());
		exitstingSchedule.setUser(schedule.getUser());

		scheduleRepository.save(exitstingSchedule);

		return exitstingSchedule;
	}

	@Override
	public void deleteSchedule(long id) {
		scheduleRepository.deleteById(id);
	}

	@Override
	public List<Schedule> getSchedulesByType(ScheduleType scheduleType) {
		List<Schedule> schedules = new ArrayList<>();
		if (scheduleRepository.count() != 0) {
			for (Schedule s : scheduleRepository.findAll()) {
				if (s.getScheduleType().equals(scheduleType)) {
					schedules.add(s);
				}
			}
			return schedules;
		}
		return schedules;
	}

	@Override
	public Schedule setSchedule(long id) {
		
		// Create a new Schedule entity
		Schedule schedule = scheduleRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Schedule", "ID", id));

        // Fetch all teams and time slots
        List<Team> teams = teamRepository.findAll();
        List<TimeSlots> timeSlots = timeSlotsRepository.findAll();

        // Loop through each team to schedule matches
        for (Team team : teams) {
            List<Match> teamMatches = matchRepository.findByHomeTeam(team);
            List<TimeSlots> availableTimeSlots = new ArrayList<>(timeSlots);

            if (!teamMatches.isEmpty()) {
                Match lastMatch = teamMatches.get(teamMatches.size() - 1);
                LocalDateTime lastMatchDate = lastMatch.getDate_time();
                
                // Remove time slots that violate the 5-day gap constraint
                availableTimeSlots.removeIf(timeSlot ->
                    ChronoUnit.DAYS.between(lastMatchDate, timeSlot.getLocalDateTime()) < 5);
            }

            for (TimeSlots timeSlot : availableTimeSlots) {
                // Check if the time slot is available for other teams too
                List<Match> matchesAtTimeSlot = matchRepository.findByTimeSlot(timeSlot);

                if (matchesAtTimeSlot.isEmpty()) {
                    // Check if the home and away matches are balanced for the team
                    int homeMatches = countHomeMatches(teamMatches, team);
                    int awayMatches = teamMatches.size() - homeMatches;

                    if (Math.abs(homeMatches - awayMatches) <= 1) {
                        // Schedule the match for the team at the available time slot
                        Match newMatch = new Match();
                        newMatch.setHomeTeam(team);
                        newMatch.setStadium(team.getStadium());
                        newMatch.setDateTime(timeSlot.getLocalDateTime());

                        // Add newMatch to schedule and save it
                        teamMatches.add(newMatch);
                        schedule.setMatchesList(teamMatches);
                        scheduleRepository.save(schedule);

                        // Update other entities and return the generated schedule
                        // ... (code for updating entities and returning the schedule)
                        return schedule;
                    }
                }
            }
        }

        // Handle case when no valid schedule can be generated
        return null;
	}
//
//		Schedule exitstingSchedule = scheduleRepository.findById(id).orElseThrow(
//				() -> new ResourceNotFoundException("Schedule", "ID", id));
//
//		List<Team> teamsAvailable = exitstingSchedule.getTeams();
//
//		int numOfTeams = exitstingSchedule.getTeams().size();
//		int numOfStadiums = stadiums.size();
//
//		boolean teamsNumEven = false;
//
//		if (numOfTeams % 2 == 0) {
//			teamsNumEven = true;
//		}
//		if (teamsNumEven) {
//
//			if (teamsAvailable.size() / 2 <= numOfStadiums) {
//				for (int i = 0; i < numOfStadiums; i += 2) {
//					Match match = new Match();
//					match.setSchedule(exitstingSchedule);
//					match.setHomeTeam(teamsAvailable.get(i));
//					match.setAwayTeam(teamsAvailable.get(++i));
//				}
//			}
//		} else {
//			
//		}
//	}

	private int countHomeMatches(List<Match> teamMatches, Team team) {
		// TODO Auto-generated method stub
		return 0;
	}

}
