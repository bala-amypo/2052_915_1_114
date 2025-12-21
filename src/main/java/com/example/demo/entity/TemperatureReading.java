package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TemperatureReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperature;

    private LocalDateTime recordedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private SensorDevice sensorDevice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public SensorDevice getSensorDevice() {
        return sensorDevice;
    }

    public void setSensorDevice(SensorDevice sensorDevice) {
        this.sensorDevice = sensorDevice;
    }
}
