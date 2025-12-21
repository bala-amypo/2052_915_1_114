package com.example.demo.controller;

import com.example.demo.entity.SensorDevice;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    @PostMapping
    public SensorDevice create(@RequestBody SensorDevice sensor) {
        return sensor;
    }

    @GetMapping
    public List<SensorDevice> getAll() {
        return Collections.emptyList();
    }

    @GetMapping("/{id}")
    public SensorDevice getById(@PathVariable Long id) {
        SensorDevice sd = new SensorDevice();
        sd.setId(id);
        return sd;
    }
}
