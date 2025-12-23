package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ServiceCounter {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
