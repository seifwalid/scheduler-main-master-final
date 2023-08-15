package com.spring.scheduler.scheduler.Dto;

import java.time.LocalDateTime;

public class MatchDto {
    public class MatchDTO {

        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public LocalDateTime getDate_time() {
            return date_time;
        }

        public void setDate_time(LocalDateTime date_time) {
            this.date_time = date_time;
        }

        public String getStadium() {
            return stadium;
        }

        public void setStadium(String stadium) {
            this.stadium = stadium;
        }

        public TeamDto getHomeTeam() {
            return homeTeam;
        }

        public void setHomeTeam(TeamDto homeTeam) {
            this.homeTeam = homeTeam;
        }

        public TeamDto getAwayTeam() {
            return awayTeam;
        }

        public void setAwayTeam(TeamDto awayTeam) {
            this.awayTeam = awayTeam;
        }

        public RefreeDto getRefree() {
            return refree;
        }

        public void setRefree(RefreeDto refree) {
            this.refree = refree;
        }

        private String type;
        private LocalDateTime date_time;
        private String stadium;
        private TeamDto homeTeam;

        private TeamDto awayTeam;
        private RefreeDto refree ;


        // Other fields, getters, and setters
    }

}
