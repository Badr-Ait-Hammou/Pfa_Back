package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Commande;
import com.example.projet_pfa.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return commandeRepository.findAll();
    }

    @Override
    public Commande findById(int id) {
        return null;
    }

    @Override
    public void delete(Commande o) {

    }
}
