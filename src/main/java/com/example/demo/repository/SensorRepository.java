package com.example.demo.repository;

import com.example.demo.entity.SensorDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SensorRepository extends JpaRepository<SensorDevice, Long> {
    Optional<SensorDevice> findByIdentifier(String identifier);
}
