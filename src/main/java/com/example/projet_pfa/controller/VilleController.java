package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Ville;
import com.example.projet_pfa.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/villes")
public class VilleController {
    @Autowired
    private VilleService villeService;
    @PostMapping("/save")
    public Ville save(@RequestBody Ville o){
        return villeService.save(o);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Ville o) {
        villeService.delete(o);
    }

    @GetMapping("/{id}")
    public Ville findById(@PathVariable String id) {
        return villeService.findById(Integer.parseInt(id));
    }

    @GetMapping("/")
    public List<Ville> findAll() {
        return villeService.findAll();
    }

}