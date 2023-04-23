package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Produit;
import com.example.projet_pfa.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;
    @PostMapping("/")
    public Produit save(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }

    @GetMapping("/{id}")
    public Produit findById(@PathVariable int id) {
        return produitService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Integer id) {
        produitService.deleteProduit(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Produit produitinfo) {
        produitService.update(id, produitinfo);
    }


}
