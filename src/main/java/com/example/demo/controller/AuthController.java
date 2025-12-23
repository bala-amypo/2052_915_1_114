package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // fixes CORS for Swagger & browser
public class AuthController {

    /**
     * LOGIN API
     * URL : POST /auth/login
     * BODY: { "username": "...", "password": "..." }
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        // 🔹 TEMP LOGIN (replace with DB/JWT later)
        if ("sac".equals(username) && "sai123".equals(password)) {

            Map<String, String> response = new HashMap<>();
            response.put("token", "dummy-jwt-token-123");

            return ResponseEntity.ok(response);
        }

        Map<String, String> error = new HashMap<>();
        error.put("error", "Invalid username or password");

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}
