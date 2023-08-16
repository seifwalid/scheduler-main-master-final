package com.spring.scheduler.scheduler.Dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class MatchDto {

        private Long id;

        private String type;
        private LocalDateTime date_time;
        private String stadium;
        private Long homeTeam;

        private Long awayTeam;
        private Long referee ;

        private Long schedule ;
        private Long timeSlot ;



        // Other fields, getters, and setters
    }

