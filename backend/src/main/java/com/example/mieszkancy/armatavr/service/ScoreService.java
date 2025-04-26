package com.example.mieszkancy.armatavr.service;

import com.example.mieszkancy.armatavr.entity.Score;
import com.example.mieszkancy.armatavr.entity.User;
import com.example.mieszkancy.armatavr.repository.ScoreRepository;
import com.example.mieszkancy.armatavr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<Score> getScoreById(String id) {
        return scoreRepository.findById(id);
    }

    public Score saveScore(Score score, User user) {
        Score savedScore = scoreRepository.save(score);
        user.getScores().add(savedScore);
        userRepository.save(user);
        return savedScore;
    }
}
