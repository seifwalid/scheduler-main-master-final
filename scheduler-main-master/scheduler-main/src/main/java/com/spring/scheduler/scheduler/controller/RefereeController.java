package com.spring.scheduler.scheduler.controller;

import java.util.List;

import com.spring.scheduler.scheduler.model.Match;
import com.spring.scheduler.scheduler.service.MatchService;
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
import com.spring.scheduler.scheduler.model.Referee;
import com.spring.scheduler.scheduler.service.RefereeService;

@RestController
@RequestMapping("/api/referee")
public class RefereeController {
    @Autowired
    private RefereeService refereeService;

    @Autowired
    private MatchService matchService;


    @GetMapping
    public List<Referee> getReferees() {
        return refereeService.getAllReferees();
    }
    @GetMapping("{id}/matches")
    public List<Match> getMatches(){return matchService.getAllMatches();}

    @GetMapping("{id}")
    public ResponseEntity<Referee> getRefereeById(@PathVariable long id) {
        return new ResponseEntity<Referee>(refereeService.getRefereeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Referee> saveReferee(@RequestBody Referee referee) {
        return new ResponseEntity<Referee>(refereeService.saveReferee(referee), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Referee> updateReferee(@RequestBody Referee referee) {
        return new ResponseEntity<Referee>(refereeService.updateReferee(referee), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void DeleteReferee(@PathVariable long id) {
        refereeService.deleteReferee(id);
    }
}
