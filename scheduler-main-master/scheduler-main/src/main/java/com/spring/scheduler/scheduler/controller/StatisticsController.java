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

import com.spring.scheduler.scheduler.model.Statistics;
import com.spring.scheduler.scheduler.service.StatisticsService;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
	private StatisticsService statistics_service;

	public StatisticsController(StatisticsService statistics_service) {
		super();
		this.statistics_service = statistics_service;
	}

	@GetMapping
	public ResponseEntity<Statistics> getStatistics(@PathVariable("id") long id) {
		return new ResponseEntity<Statistics>(statistics_service.getStatistics(id), HttpStatus.OK);
	}

	public List<Statistics> getAllStatistics() {
		return statistics_service.getAllStatistics();
	}

	@DeleteMapping("/deleteSchedule/{id}")
	public void deleteStatistics(@PathVariable("id") long id) {
		statistics_service.deleteStatistics(id);
	}

	@PostMapping("/saveStatistics")
	public ResponseEntity<Statistics> saveStatistics(@RequestBody Statistics statistics) {
		return new ResponseEntity<Statistics>(statistics_service.saveStatistics(statistics), HttpStatus.CREATED);
	}

	@PutMapping("/updateStatistics/{id}")
	public ResponseEntity<Statistics> updateStatistics(@RequestBody Statistics statistics,
			@PathVariable("id") long id) {
		return new ResponseEntity<Statistics>(statistics_service.updateStatistics(statistics, id), HttpStatus.OK);
	}
}
