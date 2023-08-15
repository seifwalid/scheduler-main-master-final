package com.spring.scheduler.scheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.spring.scheduler.scheduler.model.Team;
import com.spring.scheduler.scheduler.service.TeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable long id) {
        return new ResponseEntity<Team>(teamService.getTeamById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Team> saveTeam(@RequestBody Team team) {
        return new ResponseEntity<Team>(teamService.saveTeam(team), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        return new ResponseEntity<Team>(teamService.updateTeam(team), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteTeam(@PathVariable long id) {
        teamService.deleteTeam(id);
    }
}
