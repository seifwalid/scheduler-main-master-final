package com.spring.scheduler.scheduler.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.scheduler.scheduler.exception.ResourceNotFoundException;
import com.spring.scheduler.scheduler.model.Referee;
import com.spring.scheduler.scheduler.repository.RefereeRepository;
import com.spring.scheduler.scheduler.service.RefereeService;

@Service
public class RefereeServiceImpl implements RefereeService {

    @Autowired
    private RefereeRepository refereeRepository;

    @Override
    public List<Referee> getAllReferees() {
        return refereeRepository.findAll();
    }

    @Override
    public Referee getRefereeById(long id) {
        return refereeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Referee", "Id", id));
    }

    @Override
    public Referee saveReferee(Referee referee) {
        return refereeRepository.save(referee);
    }

    @Override
    public void deleteReferee(Long id) {
        refereeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Referee", "Id", id));
        refereeRepository.deleteById(id);
    }

    @Override
    public Referee updateReferee(Referee referee) {
        Referee existing = refereeRepository.findById(referee.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Referee", "Id", referee.getId()));
        existing.setName(referee.getName());
//        existing.setMatches(referee.getMatches());

        return refereeRepository.save(existing);
    }

}
