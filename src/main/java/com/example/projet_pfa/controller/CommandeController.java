package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Commande;
import com.example.projet_pfa.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @PostMapping("/save")
    public void save(@RequestBody Commande commande) {
         commandeService.save(commande);
    }

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @GetMapping("/{id}")
    public Commande findById(@PathVariable int id) {
        return commandeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Integer id) {
        commandeService.deleteCommande(id);
    }

    @PostMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Commande commandeinfo) {
        commandeService.update(id, commandeinfo);
    }


}
