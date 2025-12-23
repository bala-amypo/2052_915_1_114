package com.example.demo.service.impl;

import com.example.demo.entity.QueuePosition;
import com.example.demo.repository.QueuePositionRepository;
import com.example.demo.service.QueueService;
import org.springframework.stereotype.Service;

@Service
public class QueueServiceImpl implements QueueService {

    private final QueuePositionRepository queueRepository;

    public QueueServiceImpl(QueuePositionRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    @Override
    public void update(Long tokenId, Integer position) {
        QueuePosition qp = queueRepository.findByToken_Id(tokenId);
        if (qp != null) {
            qp.setPosition(position);
            queueRepository.save(qp);
        }
    }
}
