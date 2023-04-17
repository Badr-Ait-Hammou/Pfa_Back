package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Produit;
import com.example.projet_pfa.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements Dao<Produit> {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit save(Produit o) {
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return null;
    }

    @Override
    public Produit findById(int id) {
        return null;
    }

    @Override
    public void delete(Produit o) {

    }
}
