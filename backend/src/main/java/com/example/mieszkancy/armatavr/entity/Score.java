package com.example.mieszkancy.armatavr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    @MongoId
    private ObjectId id;

    @Indexed
    private String userId;

    @Field
    private int score;

    @Indexed
    private Instant timestamp;
}
