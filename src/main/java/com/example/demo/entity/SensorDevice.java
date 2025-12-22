package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class SensorDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorCode;
    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "cold_room_id")
    @JsonBackReference
    private ColdRoom coldRoom;

    @OneToMany(mappedBy = "sensorDevice", cascade = CascadeType.ALL)
    private List<TemperatureReading> readings;

    // REQUIRED default constructor
    public SensorDevice() {}

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSensorCode() {
        return sensorCode;
    }

    public void setSensorCode(String sensorCode) {
        this.sensorCode = sensorCode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ColdRoom getColdRoom() {
        return coldRoom;
    }

    public void setColdRoom(ColdRoom coldRoom) {
        this.coldRoom = coldRoom;
    }

    public List<TemperatureReading> getReadings() {
        return readings;
    }

    public void setReadings(List<TemperatureReading> readings) {
        this.readings = readings;
    }
}
