package com.example.demo.service.impl;

import com.example.demo.entity.Token;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token create() {
        Token token = new Token();
        token.setValue("T-" + System.currentTimeMillis());
        return tokenRepository.save(token);
    }

    @Override
    public Token getToken(Long id) {
        return tokenRepository.findById(id).orElse(null);
    }
}
