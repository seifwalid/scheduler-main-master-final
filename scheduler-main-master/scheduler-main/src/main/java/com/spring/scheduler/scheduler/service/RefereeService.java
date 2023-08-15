package com.spring.scheduler.scheduler.service;

import java.util.List;

import com.spring.scheduler.scheduler.model.Referee;

public interface RefereeService {
    List<Referee> getAllReferees();

    Referee getRefereeById(long id);

    Referee saveReferee(Referee referee);

    void deleteReferee(Long id);

    Referee updateReferee(Referee referee);
}
