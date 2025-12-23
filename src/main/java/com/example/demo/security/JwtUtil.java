package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email) {
        return "jwt-token-for-" + email;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt-token");
    }
}
