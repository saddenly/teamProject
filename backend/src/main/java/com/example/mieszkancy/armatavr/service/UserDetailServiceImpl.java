package com.example.mieszkancy.armatavr.service;

import com.example.mieszkancy.armatavr.entity.User;
import com.example.mieszkancy.armatavr.entity.UserPrincipal;
import com.example.mieszkancy.armatavr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User " + username + " not found")
        );

        return new UserPrincipal(user);
    }
}
