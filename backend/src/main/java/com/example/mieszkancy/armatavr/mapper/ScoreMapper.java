package com.example.mieszkancy.armatavr.mapper;

import com.example.mieszkancy.armatavr.dto.ScoreDTO;
import com.example.mieszkancy.armatavr.entity.Score;
import org.springframework.stereotype.Component;

@Component
public class ScoreMapper {
    public Score toEntity(ScoreDTO scoreDTO) {
        Score score = new Score();
        score.setLevelNumber(scoreDTO.getLevelNumber());
        score.setScore(scoreDTO.getScore());
        score.setTimestamp(scoreDTO.getTimestamp());
        return score;
    }

    public ScoreDTO toDto(Score score) {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setLevelNumber(score.getLevelNumber());
        scoreDTO.setScore(score.getScore());
        scoreDTO.setTimestamp(score.getTimestamp());
        return scoreDTO;
    }
}
