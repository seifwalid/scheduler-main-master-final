package com.spring.scheduler.scheduler.service;

import java.util.List;

import com.spring.scheduler.scheduler.model.Statistics;

public interface StatisticsService {
	Statistics saveStatistics(Statistics statistics);

	Statistics getStatistics(long id);

	List<Statistics> getAllStatistics();

	Statistics updateStatistics(Statistics statistics, long id);

	void deleteStatistics(long id);
}
