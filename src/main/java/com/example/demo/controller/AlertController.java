package com.example.demo.controller;

import com.example.demo.entity.Token;
import com.example.demo.service.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    private final TokenService tokenService;

    public AlertController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/{id}")
    public Token getAlert(@PathVariable Long id) {
        return tokenService.getToken(id);
    }
}
