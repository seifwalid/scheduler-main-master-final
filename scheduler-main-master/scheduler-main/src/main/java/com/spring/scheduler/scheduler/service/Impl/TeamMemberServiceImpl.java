package com.spring.scheduler.scheduler.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.scheduler.scheduler.exception.ResourceNotFoundException;
import com.spring.scheduler.scheduler.model.TeamMember;
import com.spring.scheduler.scheduler.repository.TeamMemberRepository;
import com.spring.scheduler.scheduler.service.TeamMemberService;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {
    private TeamMemberRepository teamMemberRepository;

    public TeamMemberServiceImpl(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    @Override
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }

    @Override
    public TeamMember getTeamMemberById(long id) {
        return teamMemberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team member", "ID", id));
    }

    @Override
    public TeamMember addTeamMember(TeamMember teamMember) {
        teamMemberRepository.save(teamMember);
        return teamMember;
    }

    @Override
    public TeamMember updateTeamMember(TeamMember teamMember) {
        TeamMember existingTeamMember = teamMemberRepository.findById(teamMember.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Team member", "ID", teamMember.getId()));
        existingTeamMember.setName(teamMember.getName());
        existingTeamMember.setKitNumber(teamMember.getKitNumber());
        existingTeamMember.setType(teamMember.getType());
        existingTeamMember.setTeam(teamMember.getTeam());

        teamMemberRepository.save(existingTeamMember);

        return existingTeamMember;
    }

    @Override
    public TeamMember deleteTeamMember(long id) {
        TeamMember existingTeamMember = teamMemberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team member", "ID", id));
        teamMemberRepository.deleteById(id);

        return existingTeamMember;
    }
}