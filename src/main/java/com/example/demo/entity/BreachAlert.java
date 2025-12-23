package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "breach_alerts")
public class BreachAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String tokenNumber;

    private String status;
    private String breachType;

    private LocalDateTime issuedAt;
    private LocalDateTime resolvedAt;

    @ManyToOne
    private ColdRoom coldRoom;

    @ManyToOne
    private SensorDevice sensor;

    public BreachAlert() {}

    public BreachAlert(String tokenNumber, ColdRoom coldRoom,
                       SensorDevice sensor, String status,
                       String breachType, LocalDateTime issuedAt) {
        this.tokenNumber = tokenNumber;
        this.coldRoom = coldRoom;
        this.sensor = sensor;
        this.status = status;
        this.breachType = breachType;
        this.issuedAt = issuedAt;
    }

    public Long getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public void setResolvedAt(LocalDateTime resolvedAt) { this.resolvedAt = resolvedAt; }
}
