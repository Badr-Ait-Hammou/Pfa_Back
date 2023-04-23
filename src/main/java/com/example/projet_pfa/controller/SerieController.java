package com.example.projet_pfa.controller;


import com.example.projet_pfa.entity.Serie;

import com.example.projet_pfa.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @PostMapping("/")
    public Serie save(@RequestBody Serie serie) { return serieService.save(serie); }

    @GetMapping("/")
    public List<Serie> findAll() { return serieService.findAll();}

    @GetMapping("/{id}")
    public Serie findById(@PathVariable int id) {return serieService.findById(id);}

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Serie serie) {serieService.update(id, serie);}

    @DeleteMapping("/{id}")
    public void deleteSerie(@PathVariable Integer id) {
        serieService.deleteSerie(id);
    }















}
