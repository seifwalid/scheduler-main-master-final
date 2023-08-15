package com.spring.scheduler.scheduler.service;

import java.util.List;

import com.spring.scheduler.scheduler.model.Team;

public interface TeamService {
    List<Team> getTeams();

    Team getTeamById(long id);

    Team saveTeam(Team team);

    Team updateTeam(Team team);

    void deleteTeam(long id);
}
