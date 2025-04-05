package com.example.mieszkancy.armatavr.service;

import com.example.mieszkancy.armatavr.entity.Score;
import com.example.mieszkancy.armatavr.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getScores() {
        return scoreRepository.findAll();
    }

    public Optional<Score> getScoreById(String id) {
        return scoreRepository.findById(id);
    }

    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }

    public void deleteScore(String id) {
        scoreRepository.deleteById(id);
    }
}
