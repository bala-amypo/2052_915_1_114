package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ServiceCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isActive;

    public Boolean getIsActive() {
        return isActive;
    }


    public ServiceCounter() {}

    public ServiceCounter(String counterName, Boolean isActive) {
        this.counterName = counterName;
        this.isActive = isActive;
    }

    public Long getId() { return id; }
    public Boolean getIsActive() { return isActive; }
}
