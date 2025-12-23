package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        if ("sac".equals(request.getUsername()) &&
            "sai123".equals(request.getPassword())) {

            return ResponseEntity.ok(
                Map.of("token", "dummy-jwt-token")
            );
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Invalid credentials"));
    }
}
