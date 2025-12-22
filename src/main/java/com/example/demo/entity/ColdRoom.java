package com.example.demo.controller;

import com.example.demo.entity.ColdRoom;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/coldrooms")
public class ColdRoomController {

    @PostMapping
    public ColdRoom create(@RequestBody ColdRoom coldRoom) {
        return coldRoom;
    }

    @GetMapping
    public List<ColdRoom> getAll() {
        return Collections.emptyList();
    }

    @GetMapping("/{id}")
    public ColdRoom getById(@PathVariable Long id) {
        ColdRoom cr = new ColdRoom();
        cr.setId(id);
        return cr;
    }
}