package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "queue_positions")
public class QueuePosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private BreachAlert token;

    private Integer position;
    private LocalDateTime updatedAt;

    public QueuePosition() {}

    public QueuePosition(BreachAlert token, Integer position) {
        this.token = token;
        this.position = position;
        this.updatedAt = LocalDateTime.now();
    }

    public void setPosition(Integer position) {
        this.position = position;
        this.updatedAt = LocalDateTime.now();
    }
}
