package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Ville;
import com.example.projet_pfa.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/villes")
@CrossOrigin
public class VilleController {

    @Autowired
    private VilleService villeService;

    @PostMapping("/save")
    public void save(@RequestBody Ville ville) {
         villeService.save(ville);
    }
    @GetMapping("/")
    public List<Ville> findAll() {
        return villeService.findAll();
    }

    @GetMapping("/{id}")
    public Ville findById(@PathVariable int id) {
        return villeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteVille(@PathVariable Integer id) {
        villeService.deleteVille(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Ville villeinfo) {
        villeService.update(id, villeinfo);
    }




}