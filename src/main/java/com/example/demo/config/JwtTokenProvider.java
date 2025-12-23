package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(Long id, String email, String role) {
        return "dummy-token";
    }
}
