package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.TokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepo;
    private final ServiceCounterRepository counterRepo;
    private final TokenLogRepository logRepo;
    private final QueuePositionRepository queueRepo;

    public TokenServiceImpl(TokenRepository t, ServiceCounterRepository c,
                            TokenLogRepository l, QueuePositionRepository q) {
        tokenRepo = t; counterRepo = c; logRepo = l; queueRepo = q;
    }

    public Token issueToken(Long counterId) {
        ServiceCounter counter = counterRepo.findById(counterId)
                .orElseThrow(() -> new ResourceNotFoundException("Counter not found"));

        if (!counter.getIsActive())
            throw new IllegalArgumentException("not active");

        Token token = new Token(
                "TKN-" + System.currentTimeMillis(),
                "WAITING",
                LocalDateTime.now(),
                counter
        );

        tokenRepo.save(token);
        queueRepo.save(new QueuePosition(token, 1));
        logRepo.save(new TokenLog(token, "Token issued"));
        return token;
    }

    public Token updateStatus(Long tokenId, String status) {
        Token token = get(tokenId);

        if (!token.getStatus().equals("WAITING"))
            throw new IllegalArgumentException("Invalid status");

        token.setStatus(status);
        if (status.equals("COMPLETED"))
            token.setCompletedAt(LocalDateTime.now());

        tokenRepo.save(token);
        logRepo.save(new TokenLog(token, "Status changed"));
        return token;
    }

    public Token get(Long id) {
        return tokenRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found"));
    }
}
