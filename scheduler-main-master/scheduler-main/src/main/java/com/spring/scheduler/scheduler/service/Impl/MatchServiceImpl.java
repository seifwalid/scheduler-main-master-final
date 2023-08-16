package com.spring.scheduler.scheduler.service.Impl;

import java.util.List;

import com.spring.scheduler.scheduler.Dto.MatchDto;
import com.spring.scheduler.scheduler.model.*;
import com.spring.scheduler.scheduler.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.scheduler.scheduler.exception.ResourceNotFoundException;
import com.spring.scheduler.scheduler.repository.MatchRepository;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchesRepository;

    public MatchServiceImpl(MatchRepository matchesRepository) {
        this.matchesRepository = matchesRepository;
    }
    @Autowired
    private TeamService teamService;
    @Autowired
    private RefereeService refereeService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private TimeSlotsService timeSlotsService;


    @Override
    public List<Match> getAllMatches() {
        List<Match> matches= matchesRepository.findAll();
        System.out.println(matches);
        return matches;
    }

    @Override
    public Match saveMatch(MatchDto match) {
        Team awayTeam = this.teamService.getTeamById(match.getAwayTeam());
        Team homeTeam = this.teamService.getTeamById(match.getHomeTeam());
        Referee referee =this.refereeService.getRefereeById(match.getReferee());
        Schedule schedule=this.scheduleService.getScheduleById(match.getSchedule());
        TimeSlots timeSlots=this.timeSlotsService.getTimeSlotById(match.getTimeSlot());

        Match matchh = new Match();
        matchh.setDateTime(match.getDate_time());
        matchh.setType(match.getType());
        matchh.setStadium(match.getStadium());
        matchh.setReferee(referee);
        matchh.setAwayTeam(awayTeam);
        matchh.setSchedule(schedule);
        matchh.setHomeTeam(homeTeam);
        matchh.setSchedule(schedule);
        matchh.setTimeSlot(timeSlots);
        return matchesRepository.save(matchh);
    }

    @Override
    public Match getMatchById(Long match_id) {
        return matchesRepository.findById(match_id)
                .orElseThrow(() -> new ResourceNotFoundException("Match", "Id", match_id));
    }

    @Override
    public void deleteMatchById(Long match_id) {
        matchesRepository.findById(match_id).orElseThrow(() -> new ResourceNotFoundException("Match", "Id", match_id));

        matchesRepository.deleteById(match_id);
    }

    @Override
    public Match updateMatch(MatchDto match, Long match_id) {
        Match matchh = matchesRepository.findById(match_id)
                .orElseThrow(() -> new ResourceNotFoundException("Match", "Id", match_id));

        Team awayTeam = this.teamService.getTeamById(match.getAwayTeam());
        Team homeTeam = this.teamService.getTeamById(match.getHomeTeam());
        Referee referee =this.refereeService.getRefereeById(match.getReferee());
        Schedule schedule=this.scheduleService.getScheduleById(match.getSchedule());
        TimeSlots timeSlots=this.timeSlotsService.getTimeSlotById(match.getTimeSlot());

              matchh.setDateTime(match.getDate_time());
        matchh.setType(match.getType());
        matchh.setStadium(match.getStadium());
        matchh.setReferee(referee);
        matchh.setAwayTeam(awayTeam);
        matchh.setSchedule(schedule);
        matchh.setHomeTeam(homeTeam);
        matchh.setSchedule(schedule);
        matchh.setTimeSlot(timeSlots);

        matchesRepository.save(matchh);

        return matchh;

    }
}
