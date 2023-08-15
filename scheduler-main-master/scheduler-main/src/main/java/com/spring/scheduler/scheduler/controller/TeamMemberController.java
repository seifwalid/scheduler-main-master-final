package com.spring.scheduler.scheduler.controller;

import java.util.List;

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

import com.spring.scheduler.scheduler.model.TeamMember;
import com.spring.scheduler.scheduler.service.TeamMemberService;

@RestController
@RequestMapping("api/team-member")
public class TeamMemberController {
    private TeamMemberService teamMemberService;

    public TeamMemberController(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @GetMapping
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberService.getAllTeamMembers();
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamMember> getTeamMemberById(@PathVariable long id) {
        return new ResponseEntity<TeamMember>(teamMemberService.getTeamMemberById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeamMember> addTeamMember(@RequestBody TeamMember teamMember) {
        return new ResponseEntity<TeamMember>(teamMemberService.addTeamMember(teamMember), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TeamMember> updateTeamMember(@RequestBody TeamMember teamMember) {
        return new ResponseEntity<TeamMember>(teamMemberService.updateTeamMember(teamMember), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteTeamMember(@PathVariable long id) {
        teamMemberService.deleteTeamMember(id);
    }
}