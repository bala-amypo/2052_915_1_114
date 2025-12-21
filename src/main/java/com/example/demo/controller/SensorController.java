package com.example.demo.controller;

import com.example.demo.entity.SensorDevice;
import com.example.demo.service.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public SensorDevice register(@RequestBody SensorDevice sensor) {
        return sensorService.register(sensor);
    }

    @PutMapping("/{id}/status")
    public SensorDevice updateStatus(@PathVariable Long id,
                                     @RequestParam Boolean active) {
        return sensorService.updateStatus(id, active);
    }

    @GetMapping
    public List<SensorDevice> getAll() {
        return sensorService.getAll();
    }
}
