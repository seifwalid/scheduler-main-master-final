package com.spring.scheduler.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.scheduler.scheduler.model.Statistics;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

}
