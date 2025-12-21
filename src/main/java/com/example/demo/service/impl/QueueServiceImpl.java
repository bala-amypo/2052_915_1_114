package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.QueueService;

public class QueueServiceImpl implements QueueService {

    private final QueuePositionRepository repo;
    private final TokenRepository tokenRepo;

    public QueueServiceImpl(QueuePositionRepository r, TokenRepository t) {
        this.repo = r;
        this.tokenRepo = t;
    }

    public QueuePosition updateQueuePosition(Long tokenId, int pos) {
        if (pos < 1) throw new IllegalArgumentException("Position >= 1");

        Token t = tokenRepo.findById(tokenId)
                .orElseThrow(() -> new RuntimeException("Token not found"));

        QueuePosition qp = repo.findByToken_Id(tokenId).orElse(new QueuePosition());
        qp.setToken(t);
        qp.setPosition(pos);
        return repo.save(qp);
    }

    public QueuePosition getPosition(Long tokenId) {
        return repo.findByToken_Id(tokenId)
                .orElseThrow(() -> new RuntimeException("Position not found"));
    }
}
