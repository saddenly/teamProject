package com.example.mieszkancy.armatavr.controller;

import com.example.mieszkancy.armatavr.entity.Score;
import com.example.mieszkancy.armatavr.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public ResponseEntity<List<Score>> getScores() {
        List<Score> scores = scoreService.getScores();
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable String id) {
        Score score = scoreService.getScoreById(id).orElseThrow();
        return ResponseEntity.ok(score);
    }

    @PostMapping
    public ResponseEntity<Score> addScore(@RequestBody Score score) {
        return ResponseEntity.ok(scoreService.saveScore(score));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Score> deleteScore(@PathVariable String id) {
        scoreService.deleteScore(id);
        return ResponseEntity.noContent().build();
    }
}
