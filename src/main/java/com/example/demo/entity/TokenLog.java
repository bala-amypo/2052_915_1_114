package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "token_logs")
public class TokenLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "token_id")
    private BreachAlert token;

    private String logMessage;
    private LocalDateTime loggedAt;

    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    public TokenLog() {
    }

    public TokenLog(BreachAlert token, String logMessage) {
        this.token = token;
        this.logMessage = logMessage;
    }

    public Long getId() {
        return id;
    }

    public BreachAlert getToken() {
        return token;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setToken(BreachAlert token) {
        this.token = token;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }
}
