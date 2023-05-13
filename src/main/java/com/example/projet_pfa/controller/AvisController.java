package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Avis;
import com.example.projet_pfa.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller/avis")
public class AvisController {



    @Autowired
    private AvisService avisService;
    @PostMapping("/save")
    public void save(@RequestBody Avis avis) {
         avisService.save(avis);
    }

    @GetMapping("/")
    public List<Avis> findAll() {
        return avisService.findAll();
    }

    @GetMapping("/{id}")
    public Avis findById(@PathVariable int id) {
        return avisService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAvis(@PathVariable Integer id) {
        avisService.deleteAvis(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Avis avisinfo) {
        avisService.update(id, avisinfo);
    }

}
