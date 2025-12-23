package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Token {
    @Id
    @GeneratedValue
    private Long id;

    private String value;

    public Long getId() { return id; }
    public String getValue() { return value; }
}
