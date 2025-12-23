package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(Long userId, String email, String role) {
        // Dummy token for now (replace with real JWT later)
        return "jwt-token-" + userId;
    }
}
