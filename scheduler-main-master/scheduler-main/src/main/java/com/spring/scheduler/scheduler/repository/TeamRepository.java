package com.spring.scheduler.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.scheduler.scheduler.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
