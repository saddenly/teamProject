package com.example.mieszkancy.armatavr.controller;

import com.example.mieszkancy.armatavr.dto.UserDTO;
import com.example.mieszkancy.armatavr.entity.User;
import com.example.mieszkancy.armatavr.mapper.UserMapper;
import com.example.mieszkancy.armatavr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users.stream().map(userMapper::toDto).toList());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with username %s not found", username))
        );
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userMapper.toDto(userService.saveUser(userMapper.toEntity(userDTO))));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with username %s not found", username))
        );
        userService.deleteUser(user);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String username, @RequestBody UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        Optional<User> existingUserOpt = userService.getUserByUsername(username);

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            user.setId(existingUser.getId());

            User savedUser = userService.saveUser(user);

            return ResponseEntity.ok(userMapper.toDto(savedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
