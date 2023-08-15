package com.spring.scheduler.scheduler.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id", nullable = false)
	private long id;

	@Column(name = "schedule_name")
	private String name;

	@Column(name = "schedule_startDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@Column(name = "schedule_endDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	@Column
	@Enumerated(EnumType.STRING)
	private ScheduleType scheduleType;

	@OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Match> matchesList;

	@ManyToMany
	@JoinTable(
	    name = "schedule_teams",
	    joinColumns = @JoinColumn(name = "schedule_id"),
	    inverseJoinColumns = @JoinColumn(name = "team_id")
	)
	private List<Team> teams;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Schedule(long id, String name, Date startDate, Date endDate, ScheduleType scheduleType,
			List<Match> matchesList, User user, List<Team> teams) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.scheduleType = scheduleType;
		this.matchesList = new ArrayList<>();
		this.user = user;
		this.teams = teams;
	}

	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public ScheduleType getScheduleType() {
		return scheduleType;
	}

	public List<Match> getMatchesList() {
		return matchesList;
	}

	public User getUser() {
		return user;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setScheduleType(ScheduleType scheduleType) {
		this.scheduleType = scheduleType;
	}

	public void setMatchesList(List<Match> matchesList) {
		this.matchesList = matchesList;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

}
