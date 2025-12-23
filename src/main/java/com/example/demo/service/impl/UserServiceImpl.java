package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User registerUser(User user) {

        if (repo.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email exists");
        }

       
        if (user.getRole() == null) {
            user.setRole("STAFF");
        }

        return repo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                   .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
