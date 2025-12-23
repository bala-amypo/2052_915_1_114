package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.config.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtProvider;

    public AuthController(UserService userService,
                          JwtTokenProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.registerUser(
                new User(
                        request.name,
                        request.email,
                        request.password,
                        request.role
                )
        );
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.email);

        AuthResponse response = new AuthResponse();
        response.token = jwtProvider.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
        response.userId = user.getId();
        response.email = user.getEmail();
        response.role = user.getRole();

        return response;
    }
}
