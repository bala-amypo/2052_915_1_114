package com.example.demo.controller;

import com.example.demo.entity.Token;
import com.example.demo.service.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/issue/{counterId}")
    public Token issue(@PathVariable Long counterId) {
        return tokenService.issueToken(counterId);
    }

    @GetMapping("/{id}")
    public Token get(@PathVariable Long id) {
        return tokenService.getToken(id);
    }

    @PutMapping("/{id}/status")
    public Token updateStatus(@PathVariable Long id,
                              @RequestParam String status) {
        return tokenService.updateStatus(id, status);
    }
}
