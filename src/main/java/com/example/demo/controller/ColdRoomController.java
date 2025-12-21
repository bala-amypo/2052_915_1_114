package com.example.demo.controller;

import com.example.demo.entity.ColdRoom;
import com.example.demo.service.ColdRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cold-rooms")
public class ColdRoomController {

    private final ColdRoomService coldRoomService;

    public ColdRoomController(ColdRoomService coldRoomService) {
        this.coldRoomService = coldRoomService;
    }

    @PostMapping
    public ColdRoom create(@RequestBody ColdRoom room) {
        return coldRoomService.create(room);
    }

    @GetMapping
    public List<ColdRoom> getAll() {
        return coldRoomService.getAll();
    }
}
