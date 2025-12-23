package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "service_counters")
public class ServiceCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean isActive;

    public ServiceCounter() {}

    public ServiceCounter(String name, Boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public Boolean getIsActive() {
        return isActive;
    }
}
