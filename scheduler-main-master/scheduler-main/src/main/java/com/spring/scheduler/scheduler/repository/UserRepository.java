package com.spring.scheduler.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.scheduler.scheduler.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
