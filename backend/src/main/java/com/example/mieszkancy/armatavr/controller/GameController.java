package com.example.mieszkancy.armatavr.controller;

import com.example.mieszkancy.armatavr.annotation.CurrentUser;
import com.example.mieszkancy.armatavr.dto.ScoreDTO;
import com.example.mieszkancy.armatavr.dto.UserDTO;
import com.example.mieszkancy.armatavr.dto.UserProgressPatchDTO;
import com.example.mieszkancy.armatavr.entity.Score;
import com.example.mieszkancy.armatavr.entity.User;
import com.example.mieszkancy.armatavr.mapper.ScoreMapper;
import com.example.mieszkancy.armatavr.mapper.UserMapper;
import com.example.mieszkancy.armatavr.repository.UserRepository;
import com.example.mieszkancy.armatavr.service.ScoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final ScoreService scoreService;
    private final ScoreMapper scoreMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public GameController(ScoreService scoreService, ScoreMapper scoreMapper, UserMapper userMapper, UserRepository userRepository) {
        this.scoreService = scoreService;
        this.scoreMapper = scoreMapper;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @GetMapping("/progress")
    public ResponseEntity<UserDTO> getProfile(@CurrentUser User user) {
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PatchMapping("/progress")
    public ResponseEntity<?> updateProfile(@CurrentUser User user,
                                           @RequestBody @Valid UserProgressPatchDTO patchDTO,
                                           BindingResult bindingResult) {
        Optional<User> optional = userRepository.findUserByUsername(user.getUsername());
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (bindingResult.hasErrors()) {
            return badRequest(bindingResult);
        }

        User userToUpdate = optional.get();
        userToUpdate.setMoney(patchDTO.getMoney());
        userToUpdate.setLevelsCompleted(patchDTO.getLevelsCompleted());
        userRepository.save(userToUpdate);
        return ResponseEntity.ok(userMapper.toDto(userToUpdate));
    }


    @PostMapping("/scores")
    public ResponseEntity<?> saveScore(@RequestBody @Valid ScoreDTO scoreDTO,
                                       BindingResult bindingResult,
                                       @CurrentUser User user) {
        if (bindingResult.hasErrors()) {
            return badRequest(bindingResult);
        }

        scoreDTO.setTimestamp(Instant.now());

        Score savedScore = scoreService.saveScore(scoreMapper.toEntity(scoreDTO), user);

        return ResponseEntity.created(URI.create("/api/game/scores/" + savedScore.getId()))
                .body(scoreMapper.toDto(scoreService.getScoreById(savedScore.getId()).get()));
    }

    @GetMapping("/scores")
    public ResponseEntity<List<ScoreDTO>> getScores(@CurrentUser User user) {
        return ResponseEntity.ok(user.getScores().stream().map(scoreMapper::toDto).toList());
    }

    @GetMapping("/scores/{level}")
    public ResponseEntity<?> getScore(@PathVariable int level, @CurrentUser User user) {
        if (level >= 1)
            return ResponseEntity.ok(user.getScores().stream().filter(score -> score.getLevelNumber() == level)
                    .map(scoreMapper::toDto).toList());
        else
            return ResponseEntity.badRequest().body("Level cannot be lower that 0");
    }

    private ResponseEntity<?> badRequest(BindingResult bindingResult) {
        List<String> errors = bindingResult.getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest().body(errors);
    }
}
