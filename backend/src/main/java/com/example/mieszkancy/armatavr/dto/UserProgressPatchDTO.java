package com.example.mieszkancy.armatavr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProgressPatchDTO {
    private int levelsCompleted;

    private int currency;
}
