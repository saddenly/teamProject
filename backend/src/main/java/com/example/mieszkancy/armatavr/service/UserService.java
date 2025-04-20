package com.example.mieszkancy.armatavr.service;

import com.example.mieszkancy.armatavr.entity.User;
import com.example.mieszkancy.armatavr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.encoder = new BCryptPasswordEncoder();
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public String login(User user) {
        if (userRepository.findUserByUsername(user.getUsername()).isEmpty()) {
            user.setPassword(encoder.encode("dummy"));
            user.setCreatedAt(Instant.now());
            user.setScores(new ArrayList<>());
            userRepository.save(user);
        }
        return jwtService.generateToken(user.getUsername());
    }
}
