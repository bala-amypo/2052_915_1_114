package com.example.demo.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachAlert;
import com.example.demo.entity.QueuePosition;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.QueuePositionRepository;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.QueueService;

@Service
public class QueueServiceImpl implements QueueService {

    private final QueuePositionRepository queueRepo;
    private final TokenRepository tokenRepo;

    public QueueServiceImpl(QueuePositionRepository queueRepo,
                            TokenRepository tokenRepo) {
        this.queueRepo = queueRepo;
        this.tokenRepo = tokenRepo;
    }

    @Override
    public QueuePosition updateQueuePosition(Long tokenId, Integer newPosition) {
        if (newPosition < 1) {
            throw new IllegalArgumentException("Position must be >= 1");
        }

        BreachAlert token = tokenRepo.findById(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found"));

        QueuePosition position = queueRepo.findByTokenId(tokenId)
                .orElse(new QueuePosition(token, newPosition, LocalDateTime.now()));

        position.setPosition(newPosition);
        position.setUpdatedAt(LocalDateTime.now());

        return queueRepo.save(position);
    }

    @Override
    public QueuePosition getPosition(Long tokenId) {
        return queueRepo.findByTokenId(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Queue position not found"));
    }
}
