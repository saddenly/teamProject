package com.example.mieszkancy.armatavr.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Document
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    @Id
    private String id;

    @Indexed
    private String userId;

    @Field
    private int score;

    @Indexed
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
        return "Score{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", score=" + score +
                ", timestamp=" + timestamp +
                '}';
    }
}
