package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Zone;
import com.example.projet_pfa.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {
    @Autowired
    private ZoneService zoneService;

    @PostMapping("/save")
    public Zone save(@RequestBody Zone o) {
        return zoneService.save(o);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Zone o) {
        zoneService.delete(o);
    }

    @GetMapping("/{id}")
    public Zone findById(@PathVariable String id) {
        return zoneService.findById(Integer.parseInt(id));
    }

    @GetMapping("/")
    public List<Zone> findAll() {
        return zoneService.findAll();
    }
}

