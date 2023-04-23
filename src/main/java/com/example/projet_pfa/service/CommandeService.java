package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Avis;
import com.example.projet_pfa.entity.Commande;
import com.example.projet_pfa.entity.Ville;
import com.example.projet_pfa.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService implements Dao<Commande> {

    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> findAll() {
        return commandeRepository.findAll() ;
    }

    @Override
    public Commande findById(int id) {
        return commandeRepository.findById(id);
    }

    @Override
    public void delete(Commande o) {

    }
    public void deleteCommande(Integer id){
        Commande commande = commandeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("commande not found with id " + id));
        commandeRepository.delete(commande);
    }
    public void update(Integer id, Commande commandeinfo) {
        Commande commande=commandeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("commande not found with id " + id));
        commande.setDateCommande(commandeinfo.getDateCommande());
        commande.setPrixCommande(commandeinfo.getPrixCommande());
        commande.setEtatCommande(commandeinfo.getEtatCommande());
        commande.setAvis(commandeinfo.getAvis());
        commande.setUser(commandeinfo.getUser());
        commande.setReference(commandeinfo.getReference());
        commande.setTelephone(commandeinfo.getTelephone());
        commande.setAdresseLivraison(commandeinfo.getAdresseLivraison());
        commandeRepository.save(commande);
    }
}
