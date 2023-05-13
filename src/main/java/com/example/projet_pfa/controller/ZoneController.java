package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Zone;
import com.example.projet_pfa.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/controller/zones")
@CrossOrigin
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @PostMapping("/save")
    public void save(@RequestBody Zone zone) {
         zoneService.save(zone);
    }

    @GetMapping("/")
    public List<Zone> findAll() {
        return zoneService.findAll();
    }

    @GetMapping("/{id}")
    public Zone findById(@PathVariable int id) {
        return zoneService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteZone(@PathVariable Integer id) {
        zoneService.deleteZone(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Zone zoneinfo) {
        zoneService.update(id, zoneinfo);
    }


}

