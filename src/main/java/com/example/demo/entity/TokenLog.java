package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TokenLog {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Token token;

    private String message;
    private LocalDateTime loggedAt = LocalDateTime.now();

    public void setMessage(String message) {
        this.message = message;
    }
}
