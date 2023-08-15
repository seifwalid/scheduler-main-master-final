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

import com.spring.scheduler.scheduler.model.Match;
import com.spring.scheduler.scheduler.service.MatchService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    public MatchController() {

    }

    public MatchController(MatchService matchService) {
        this.matchService = matchService;

    }

    @GetMapping("/matches")
    public List<Match> matchesList() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{match_id}")
    public Match match(@PathVariable long match_id){return matchService.getMatchById(match_id);}
    @PostMapping("/addmatch")
    public ResponseEntity<Match> addMatch(@RequestBody Match match, HttpSession session) {

        session.setAttribute("match", match);
        return new ResponseEntity<Match>(matchService.saveMatch(match), HttpStatus.CREATED);
    }

    @PutMapping("/{match_id}")
    public ResponseEntity<Match> editMatch(@PathVariable Long match_id, @RequestBody Match match, HttpSession session) {

        session.getAttribute("match");

        return new ResponseEntity<Match>(matchService.updateMatch(match, match_id), HttpStatus.OK);
    }

    @DeleteMapping("/{match_id}")
    public void deleteMatch(@PathVariable Long match_id, HttpSession session) {

        session.getAttribute("match");
        matchService.deleteMatchById(match_id);

    }
}
