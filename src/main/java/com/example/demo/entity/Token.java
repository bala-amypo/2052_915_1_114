package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String tokenNumber;

    @ManyToOne
    @JoinColumn(name = "cold_room_id")
    private ColdRoom coldRoom;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private SensorDevice sensor;

    @ManyToOne
    @JoinColumn(name = "reading_id")
    private TemperatureReading reading;

    private String status;      // OPEN, ACKNOWLEDGED, RESOLVED, CANCELLED
    private String breachType;  // HIGH or LOW

    private LocalDateTime issuedAt;
    private LocalDateTime resolvedAt;

    @OneToOne(mappedBy = "token")
    private QueuePosition queuePosition;

    @OneToMany(mappedBy = "token")
    private List<TokenLog> logs;

    // ✅ No-arg constructor
    public Token() {
    }

    // ✅ Parameterized constructor (CORRECT)
    public Token(String tokenNumber,
                 ColdRoom coldRoom,
                 SensorDevice sensor,
                 TemperatureReading reading,
                 String status,
                 String breachType,
                 LocalDateTime issuedAt,
                 LocalDateTime resolvedAt) {

        this.tokenNumber = tokenNumber;
        this.coldRoom = coldRoom;
        this.sensor = sensor;
        this.reading = reading;
        this.status = status;
        this.breachType = breachType;
        this.issuedAt = issuedAt;
        this.resolvedAt = resolvedAt;
    }

    // ✅ Getters and Setters

    public Long getId() {
        return id;
    }

    public String getTokenNumber() {
        return tokenNumber;
    }

    public ColdRoom getColdRoom() {
        return coldRoom;
    }

    public SensorDevice getSensor() {
        return sensor;
    }

    public TemperatureReading getReading() {
        return reading;
    }

    public String getStatus() {
        return status;
    }

    public String getBreachType() {
        return breachType;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public void setColdRoom(ColdRoom coldRoom) {
        this.coldRoom = coldRoom;
    }

    public void setSensor(SensorDevice sensor) {
        this.sensor = sensor;
    }

    public void setReading(TemperatureReading reading) {
        this.reading = reading;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBreachType(String breachType) {
        this.breachType = breachType;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }
}
