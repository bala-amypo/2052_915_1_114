package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
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
        response.userId = user.getId();
        response.email = user.getEmail();
        response.role = user.getRole();
        response.token = "NO_SECURITY_MODE";

        return response;
    }
}
