package com.example.projet_pfa.controller;


import com.example.projet_pfa.entity.Serie;
import com.example.projet_pfa.entity.Specialite;
import com.example.projet_pfa.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller/specialites")
@CrossOrigin
public class SpecialiteController {

    @Autowired
    private SpecialiteService specialiteService;


    @PostMapping("/save")
    public void save(@RequestBody Specialite specialite) {  specialiteService.save(specialite); }

    @GetMapping("/")
    public List<Specialite> findAll() { return specialiteService.findAll();}

    @GetMapping("/{id}")
    public Specialite findById(@PathVariable int id) {return specialiteService.findById(id);}

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Specialite specialite) {specialiteService.update(id, specialite);}

    @DeleteMapping("/{id}")
    public void deleteSpecialite(@PathVariable Integer id) {
        specialiteService.deleteSpecialite(id);
    }

















}
