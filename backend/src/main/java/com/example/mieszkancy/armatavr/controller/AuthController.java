package com.example.mieszkancy.armatavr.controller;

import com.example.mieszkancy.armatavr.dto.UserDTO;
import com.example.mieszkancy.armatavr.mapper.UserMapper;
import com.example.mieszkancy.armatavr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    private final UserMapper userMapper;

    @Autowired
    public AuthController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {
        return userService.login(userMapper.toEntity(userDTO));
    }
}
