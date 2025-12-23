package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sensor_devices")
public class SensorDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String identifier;

    @ManyToOne
    private ColdRoom coldRoom;

    private Boolean isActive;

    public SensorDevice() {}

    public SensorDevice(String identifier, ColdRoom coldRoom, Boolean isActive) {
        this.identifier = identifier;
        this.coldRoom = coldRoom;
        this.isActive = isActive;
    }

    public String getIdentifier() { return identifier; }
    public Boolean getIsActive() { return isActive; }
    public ColdRoom getColdRoom() { return coldRoom; }
}
