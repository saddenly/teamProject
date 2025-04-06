package com.example.mieszkancy.armatavr.mapper;

import com.example.mieszkancy.armatavr.dto.ScoreDTO;
import com.example.mieszkancy.armatavr.entity.Score;
import org.springframework.stereotype.Component;

@Component
public class ScoreMapper {
    public Score toEntity(ScoreDTO scoreDTO){
        Score score = new Score();
        score.setId(scoreDTO.getId());
        score.setUserId(scoreDTO.getUserId());
        score.setScore(scoreDTO.getScore());
        score.setTimestamp(scoreDTO.getTimestamp());
        return score;
    }

    public ScoreDTO toDto(Score score){
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setId(score.getId());
        scoreDTO.setUserId(score.getUserId());
        scoreDTO.setScore(score.getScore());
        scoreDTO.setTimestamp(score.getTimestamp());
        return scoreDTO;
    }
}
