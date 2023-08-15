package com.spring.scheduler.scheduler.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matches")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long id;

    @Column
    private String type;

    @Column
    private LocalDateTime date_time;

    @Column
    private String stadium;

    @ManyToOne
    @JsonManagedReference
    @JsonIgnore
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne


    @JoinColumn(name = "team1_id")
    private Team homeTeam;

    @ManyToOne

        @JoinColumn(name = "team2_id")
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "referee_id")
    private Referee referee;
    
    @ManyToOne

    @JoinColumn(name = "time_slot_id") // Use the actual column name in your database
    private TimeSlots timeSlot;
    

    public Match() {

    }

    public Match(String type, LocalDateTime date_time, String stadium, Schedule schedule, Team homeTeam, Team awayTeam,
            Referee referee) {
        this.type = type;
        this.date_time = date_time;
        this.stadium = stadium;
        this.schedule = schedule;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.referee = referee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return date_time;
    }

    public void setDateTime(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }
    
    public TimeSlots getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlots timeSlot) {
        this.timeSlot = timeSlot;
    }

}
