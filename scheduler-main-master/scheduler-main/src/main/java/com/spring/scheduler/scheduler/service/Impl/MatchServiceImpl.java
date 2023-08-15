package com.spring.scheduler.scheduler.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.scheduler.scheduler.exception.ResourceNotFoundException;
import com.spring.scheduler.scheduler.model.Match;
import com.spring.scheduler.scheduler.repository.MatchRepository;
import com.spring.scheduler.scheduler.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchesRepository;

    public MatchServiceImpl(MatchRepository matchesRepository) {
        this.matchesRepository = matchesRepository;
    }

    @Override
    public List<Match> getAllMatches() {
        List<Match> matches= matchesRepository.findAll();
        System.out.println(matches);
        return matches;
    }

    @Override
    public Match saveMatch(Match match) {
        return matchesRepository.save(match);
    }

    @Override
    public Match getMatchById(Long match_id) {
        return matchesRepository.findById(match_id)
                .orElseThrow(() -> new ResourceNotFoundException("Match", "Id", match_id));
    }

    @Override
    public void deleteMatchById(Long match_id) {
        matchesRepository.findById(match_id).orElseThrow(() -> new ResourceNotFoundException("Match", "Id", match_id));

        matchesRepository.deleteById(match_id);
    }

    @Override
    public Match updateMatch(Match match, Long match_id) {
        Match existingMatch = matchesRepository.findById(match_id)
                .orElseThrow(() -> new ResourceNotFoundException("Match", "Id", match_id));

        existingMatch.setType(match.getType());
        existingMatch.setDateTime(match.getDateTime());
        existingMatch.setStadium(match.getStadium());
        existingMatch.setSchedule(match.getSchedule());
        existingMatch.setAwayTeam(match.getAwayTeam());
        existingMatch.setHomeTeam(match.getHomeTeam());

        matchesRepository.save(existingMatch);

        return existingMatch;

    }
}
