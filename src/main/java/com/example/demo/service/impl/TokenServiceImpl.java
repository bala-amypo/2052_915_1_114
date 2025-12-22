package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.TokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    private final ServiceCounterRepository counterRepository;
    private final QueuePositionRepository queueRepository;
    private final TokenLogRepository logRepository;

    public TokenServiceImpl(TokenRepository tokenRepository,
                            ServiceCounterRepository counterRepository,
                            QueuePositionRepository queueRepository,
                            TokenLogRepository logRepository) {
        this.tokenRepository = tokenRepository;
        this.counterRepository = counterRepository;
        this.queueRepository = queueRepository;
        this.logRepository = logRepository;
    }

    // POST /tokens/counter/{id}
    @Override
    public Token issueToken(Long counterId) {

        ServiceCounter counter = counterRepository.findById(counterId)
                .orElseThrow(() -> new ResourceNotFoundException("Counter not found"));

        if (!counter.getIsActive()) {
            throw new IllegalArgumentException("not active");
        }

        Token token = new Token(
                "TKN-" + System.currentTimeMillis(),
                "WAITING",
                LocalDateTime.now(),
                counter
        );

        tokenRepository.save(token);

        QueuePosition queue = new QueuePosition(token, 1, LocalDateTime.now());
        queueRepository.save(queue);

        TokenLog log = new TokenLog(token, "Token issued");
        logRepository.save(log);

        return token;
    }

    // PUT /tokens/{id}/status
    @Override
    public Token updateStatus(Long tokenId, String status) {

        Token token = get(tokenId);

        // Allowed transition: WAITING -> COMPLETED
        if (!token.getStatus().equals("WAITING")) {
            throw new IllegalArgumentException("Invalid status");
        }

        token.setStatus(status);

        if ("COMPLETED".equals(status)) {
            token.setCompletedAt(LocalDateTime.now());
        }

        tokenRepository.save(token);

        TokenLog log = new TokenLog(token, "Status changed to " + status);
        logRepository.save(log);

        return token;
    }

    // GET /tokens/{id}
    @Override
    public Token get(Long tokenId) {
        return tokenRepository.findById(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found"));
    }
}
