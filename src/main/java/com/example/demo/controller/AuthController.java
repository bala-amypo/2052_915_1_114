package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwt;
    private final PasswordEncoder encoder;

    public AuthController(UserService userService,
                          JwtTokenProvider jwt,
                          PasswordEncoder encoder) {
        this.userService = userService;
        this.jwt = jwt;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest req) {
        return userService.registerUser(
                new User(req.getName(), req.getEmail(),
                         req.getPassword(), req.getRole()));
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        User user = userService.findByEmail(req.getEmail());
        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        return new AuthResponse(
                jwt.generateToken(user.getId(), user.getEmail(), user.getRole()),
                user.getId(), user.getEmail(), user.getRole());
    }
}
