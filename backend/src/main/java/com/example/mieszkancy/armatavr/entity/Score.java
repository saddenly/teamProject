package com.example.mieszkancy.armatavr.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    private int levelNumber;

    private int score;

    @Indexed
    private Instant timestamp;

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

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    @Override
    public String toString() {
        return "Score{" +
                "levelNumber=" + levelNumber +
                ", score=" + score +
                ", timestamp=" + timestamp +
                '}';
    }
}
