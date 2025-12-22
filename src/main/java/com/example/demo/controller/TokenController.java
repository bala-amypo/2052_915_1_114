package com.example.demo.controller;

import com.example.demo.entity.Token;
import com.example.demo.service.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    private final TokenService service;

    public TokenController(TokenService service) {
        this.service = service;
    }

    @PostMapping("/counter/{id}")
    public Token issue(@PathVariable Long id) {
        return service.issueToken(id);
    }

    @PutMapping("/{id}/status")
    public Token update(@PathVariable Long id,
                        @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/{id}")
    public Token get(@PathVariable Long id) {
        return service.get(id);
    }
}
