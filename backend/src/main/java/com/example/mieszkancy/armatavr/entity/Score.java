package com.example.mieszkancy.armatavr.entity;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@AllArgsConstructor
public class Score {
    private String id;

    private int levelNumber;

    private int score;

    @Indexed
    private Instant timestamp;

    public Score() {
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

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id='" + id + '\'' +
                ", levelNumber=" + levelNumber +
                ", score=" + score +
                ", timestamp=" + timestamp +
                '}';
    }
}
