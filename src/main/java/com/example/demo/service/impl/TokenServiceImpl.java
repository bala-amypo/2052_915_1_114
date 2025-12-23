package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachAlert;
import com.example.demo.entity.ServiceCounter;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ServiceCounterRepository;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepo;
    private final ServiceCounterRepository counterRepo;

    public TokenServiceImpl(TokenRepository tokenRepo,
                            ServiceCounterRepository counterRepo) {
        this.tokenRepo = tokenRepo;
        this.counterRepo = counterRepo;
    }

    @Override
    public BreachAlert createToken(Long counterId) {
        ServiceCounter counter = counterRepo.findById(counterId)
                .orElseThrow(() -> new ResourceNotFoundException("Counter not found"));

        if (!Boolean.TRUE.equals(counter.getIsActive())) {
            throw new IllegalArgumentException("Counter not active");
        }

        BreachAlert alert = new BreachAlert(
                UUID.randomUUID().toString(),
                "OPEN",
                LocalDateTime.now()
        );

        return tokenRepo.save(alert);
    }

    @Override
    public BreachAlert updateStatus(Long tokenId, String status) {
        BreachAlert alert = getToken(tokenId);
        alert.setStatus(status);
        return tokenRepo.save(alert);
    }

    @Override
    public BreachAlert getToken(Long tokenId) {
        return tokenRepo.findById(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found"));
    }
}
