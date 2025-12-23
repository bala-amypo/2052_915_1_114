package com.example.demo.config;

import com.example.demo.security.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;
}
