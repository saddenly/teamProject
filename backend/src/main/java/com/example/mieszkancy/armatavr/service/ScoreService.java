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

    private final ScoreRepository scoreRepository;

    private final UserRepository userRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository, UserRepository userRepository) {
        this.scoreRepository = scoreRepository;
        this.userRepository = userRepository;
    }

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
