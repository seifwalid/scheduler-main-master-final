package com.spring.scheduler.scheduler.service;

import java.util.List;

import com.spring.scheduler.scheduler.model.TeamMember;

public interface TeamMemberService {
    List<TeamMember> getAllTeamMembers();

    TeamMember getTeamMemberById(long id);

    TeamMember addTeamMember(TeamMember teamMember);

    TeamMember updateTeamMember(TeamMember teamMember);

    TeamMember deleteTeamMember(long id);
}
