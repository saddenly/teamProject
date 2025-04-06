package com.example.mieszkancy.armatavr.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO {
    private String id;

    private String userId;

    private int score;

    private Instant timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "ScoreDTO{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", score=" + score +
                ", timestamp=" + timestamp +
                '}';
    }
}
