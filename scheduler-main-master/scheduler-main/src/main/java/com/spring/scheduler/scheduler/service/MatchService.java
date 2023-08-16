package com.spring.scheduler.scheduler.service;

import java.util.List;

import com.spring.scheduler.scheduler.Dto.MatchDto;
import com.spring.scheduler.scheduler.model.Match;;

public interface MatchService {

    public List<Match> getAllMatches();

    public Match saveMatch(MatchDto match);

    public Match getMatchById(Long match_id);

    public Match updateMatch(MatchDto match, Long match_id);

    public void deleteMatchById(Long match_id);
}
