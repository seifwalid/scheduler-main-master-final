package com.spring.scheduler.scheduler.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.scheduler.scheduler.exception.ResourceNotFoundException;
import com.spring.scheduler.scheduler.model.Team;
import com.spring.scheduler.scheduler.repository.TeamRepository;
import com.spring.scheduler.scheduler.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(long id) {
        return teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Team", "id", id));
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Team team) {
        Team existing = teamRepository.findById(team.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Team", "id", team.getId()));

        existing.setName(team.getName());
        existing.setStadium(team.getStadium());

        return teamRepository.save(existing);
    }

    @Override
    public void deleteTeam(long id) {
        teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Team", "id", id));
        teamRepository.deleteById(id);
    }

}
