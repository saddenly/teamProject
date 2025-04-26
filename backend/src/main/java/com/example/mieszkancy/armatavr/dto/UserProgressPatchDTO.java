package com.example.mieszkancy.armatavr.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProgressPatchDTO {
    @Positive
    private int levelsCompleted;

    @PositiveOrZero
    private int money;
}
