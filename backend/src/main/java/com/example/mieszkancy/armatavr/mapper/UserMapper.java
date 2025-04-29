package com.example.mieszkancy.armatavr.mapper;

import com.example.mieszkancy.armatavr.dto.UserDTO;
import com.example.mieszkancy.armatavr.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setLevelsCompleted(userDTO.getLevelsCompleted());
        user.setMoney(userDTO.getMoney());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setScores(userDTO.getScores());
        return user;
    }

    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setLevelsCompleted(user.getLevelsCompleted());
        userDTO.setMoney(user.getMoney());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setScores(user.getScores());
        return userDTO;
    }
}
