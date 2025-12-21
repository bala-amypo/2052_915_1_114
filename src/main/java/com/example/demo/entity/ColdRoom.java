package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ColdRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;

    private String location;

    private Double minTemperature;
    private Double maxTemperature;

    @OneToMany(mappedBy = "coldRoom", cascade = CascadeType.ALL)
    private List<SensorDevice> sensors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public List<SensorDevice> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorDevice> sensors) {
        this.sensors = sensors;
    }
}
