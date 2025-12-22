package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Base64;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public User register(User user) {
        if (repo.findByEmail(user.getEmail()).isPresent())
            throw new IllegalArgumentException("Email already exists");

        if (user.getRole() == null)
            user.setRole("STAFF");

        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
