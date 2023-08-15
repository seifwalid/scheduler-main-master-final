package com.spring.scheduler.scheduler.model;

import java.util.List;

public class Constraints {

	private static final int minDaysBetweenMatches = 5;
	private List<String> availableStadiums;

	public Constraints(List<String> availableStadium) {
		super();
		this.availableStadiums = availableStadium;
	}

	public int getMinDaysBetweenMatches() {
		return minDaysBetweenMatches;
	}

	public List<String> getAvailableStadium() {
		return availableStadiums;
	}

}
