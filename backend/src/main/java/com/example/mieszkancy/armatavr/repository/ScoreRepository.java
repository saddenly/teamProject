package com.example.mieszkancy.armatavr.repository;

import com.example.mieszkancy.armatavr.entity.Score;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends MongoRepository<Score, String> {

}
