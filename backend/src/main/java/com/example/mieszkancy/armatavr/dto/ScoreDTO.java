package com.example.mieszkancy.armatavr.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO {
    private String id;

    private int levelNumber;

    private int score;

    private Instant timestamp;

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ScoreDTO{" +
                "id='" + id + '\'' +
                ", levelNumber=" + levelNumber +
                ", score=" + score +
                ", timestamp=" + timestamp +
                '}';
    }
}
