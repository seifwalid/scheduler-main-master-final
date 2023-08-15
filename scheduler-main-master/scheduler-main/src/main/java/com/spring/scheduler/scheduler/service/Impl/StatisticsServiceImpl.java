package com.spring.scheduler.scheduler.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.scheduler.scheduler.exception.ResourceNotFoundException;
import com.spring.scheduler.scheduler.model.Statistics;
import com.spring.scheduler.scheduler.repository.StatisticsRepository;
import com.spring.scheduler.scheduler.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    StatisticsRepository statisticsRepository;

    @Override
    public Statistics getStatistics(long id) {
        Statistics existing = statisticsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Statistics", "Id", id));

        return existing;
    }

    @Override
    public List<Statistics> getAllStatistics() {
        return statisticsRepository.findAll();
    }

    @Override
    public void deleteStatistics(long id) {
        statisticsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Statistics", "Id", id));
        statisticsRepository.deleteById(id);
    }

    @Override
    public Statistics saveStatistics(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    @Override
    public Statistics updateStatistics(Statistics statistics, long id) {
        Statistics existing = statisticsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Statistics", "Id", id));

        existing.setCorners(statistics.getCorners());
        existing.setGoals(statistics.getGoals());
        existing.setOffside(statistics.getOffside());
        existing.setPercentageOfPossesion(statistics.getPercentageOfPossesion());
        existing.setRedCards(statistics.getRedCards());
        existing.setYellowCards(statistics.getYellowCards());

        statisticsRepository.save(existing);

        return existing;
    }

}
