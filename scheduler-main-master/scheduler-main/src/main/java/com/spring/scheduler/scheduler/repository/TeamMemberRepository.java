package com.spring.scheduler.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.scheduler.scheduler.model.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

}
