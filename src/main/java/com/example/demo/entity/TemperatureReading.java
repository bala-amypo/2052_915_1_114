package com.example.demo.entity;

import java.time.LocalDateTime;

public class TemperatureReading {

    private Long id;
    private SensorDevice sensorDevice;
    private Double temperature;
    private LocalDateTime recordedAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public SensorDevice getSensorDevice() { return sensorDevice; }
    public void setSensorDevice(SensorDevice sensorDevice) { this.sensorDevice = sensorDevice; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public LocalDateTime getRecordedAt() { return recordedAt; }
}
