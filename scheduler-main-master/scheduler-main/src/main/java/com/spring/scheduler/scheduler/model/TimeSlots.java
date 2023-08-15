package com.spring.scheduler.scheduler.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class TimeSlots {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "time_slot_id")
	private long id;
	
	@Column(nullable = false)
	private LocalDateTime localDateTime;

	public TimeSlots(LocalDateTime localDateTime) {
		super();
		this.localDateTime = localDateTime;
	}

	public TimeSlots() {
		super();
	}

	public long getId() {
		return id;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	
	
	
}
