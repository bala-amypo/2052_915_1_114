package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String tokenNumber;

    private String status;

    private LocalDateTime issuedAt;
    private LocalDateTime completedAt;

    @ManyToOne
    private ServiceCounter serviceCounter;

    public Token() {}

    public Token(String tokenNumber, String status, LocalDateTime issuedAt, ServiceCounter counter) {
        this.tokenNumber = tokenNumber;
        this.status = status;
        this.issuedAt = issuedAt;
        this.serviceCounter = counter;
    }

    // 🔴 REQUIRED GETTERS / SETTERS
    public Long getId() { return id; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
