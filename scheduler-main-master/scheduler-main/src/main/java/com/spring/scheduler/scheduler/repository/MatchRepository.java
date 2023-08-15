package com.spring.scheduler.scheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.scheduler.scheduler.model.Match;
import com.spring.scheduler.scheduler.model.Team;
import com.spring.scheduler.scheduler.model.TimeSlots;

public interface MatchRepository extends JpaRepository<Match, Long> {

    public Match findByType(String type);

    public Match findByStadium(String stadium);
    
    List<Match> findByHomeTeam(Team homeTeam);
    
    List<Match> findByAwayTeam(Team awayTeam);
    
    public List<Match> findByTimeSlot(TimeSlots timeSlot);
}
