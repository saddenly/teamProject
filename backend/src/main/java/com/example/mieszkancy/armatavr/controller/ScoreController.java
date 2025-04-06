package com.example.mieszkancy.armatavr.controller;

import com.example.mieszkancy.armatavr.dto.ScoreDTO;
import com.example.mieszkancy.armatavr.entity.Score;
import com.example.mieszkancy.armatavr.mapper.ScoreMapper;
import com.example.mieszkancy.armatavr.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreService scoreService;
    private final ScoreMapper scoreMapper;

    @Autowired
    public ScoreController(ScoreService scoreService, ScoreMapper scoreMapper) {
        this.scoreService = scoreService;
        this.scoreMapper = scoreMapper;
    }

    @GetMapping
    public ResponseEntity<List<ScoreDTO>> getScores() {
        List<Score> scores = scoreService.getScores();
        return ResponseEntity.ok(scores.stream().map(scoreMapper::toDto).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoreDTO> getScoreById(@PathVariable String id) {
        Score score = scoreService.getScoreById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Score with id %s not found", id))
        );
        return ResponseEntity.ok(scoreMapper.toDto(score));
    }

    @PostMapping
    public ResponseEntity<ScoreDTO> addScore(@RequestBody ScoreDTO scoreDTO) {
        return ResponseEntity.ok(scoreMapper.toDto(scoreService.saveScore(scoreMapper.toEntity(scoreDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ScoreDTO> deleteScore(@PathVariable String id) {
        Score score = scoreService.getScoreById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Score with id %s not found", id))
        );
        return ResponseEntity.noContent().build();
    }
}
