package com.spring.scheduler.scheduler.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "statistics")

public class Statistics {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "goals")
	private int goals;

	@Column(name = "corners")
	private int corners;

	@Column(name = "ofside")
	private String offside;

	@Column(name = "yellowCards")
	private int yellowCards;

	@Column(name = "redCards")
	private int redCards;

	@Column(name = "percentageOfPossesion")
	private String percentageOfPossesion;

	@OneToOne
	@JoinColumn(name = "match_id")
	private Match matches;

	@OneToOne
	@JoinColumn(name = "team_id")
	private Team teams;

	public long getId() {
		return id;
	}

	public Statistics(int goals, int corners, String offside, int yellowCards, int redCards,
			String percentageOfPossesion) {
		super();
		this.goals = goals;
		this.corners = corners;
		this.offside = offside;
		this.yellowCards = yellowCards;
		this.redCards = redCards;
		this.percentageOfPossesion = percentageOfPossesion;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getCorners() {
		return corners;
	}

	public void setCorners(int corners) {
		this.corners = corners;
	}

	public String getOffside() {
		return offside;
	}

	public void setOffside(String offside) {
		this.offside = offside;
	}

	public int getYellowCards() {
		return yellowCards;
	}

	public void setYellowCards(int yellowCards) {
		this.yellowCards = yellowCards;
	}

	public int getRedCards() {
		return redCards;
	}

	public void setRedCards(int redCards) {
		this.redCards = redCards;
	}

	public String getPercentageOfPossesion() {
		return percentageOfPossesion;
	}

	public void setPercentageOfPossesion(String percentageOfPossesion) {
		this.percentageOfPossesion = percentageOfPossesion;
	}

}