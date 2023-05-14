package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Avis;
import com.example.projet_pfa.entity.Produit;
import com.example.projet_pfa.entity.Zone;
import com.example.projet_pfa.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements Dao<Produit> {

    public List<Produit> findProduitsByRestaurant(Integer id) {
        return produitRepository.findProduitsByRestaurant(id);
    }

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit findById(int id) {
        return produitRepository.findById(id);
    }

    @Override
    public void delete(Produit o) {

    }
    public void deleteProduit(Integer id){
        Produit produit = produitRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id " + id));
        produitRepository.delete(produit);
    }
    public void update(Integer id, Produit produitinfo) {
        Produit produit=produitRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("produit not found with id " + id));
        produit.setNom(produitinfo.getNom());
        produit.setDescription(produitinfo.getDescription());
        produit.setStock(produitinfo.getStock());
        produit.setPromotion(produitinfo.getPromotion());
        produit.setPhoto(produitinfo.getPhoto());
        produit.setPrix(produitinfo.getPrix());
        produit.setRestaurant(produitinfo.getRestaurant());
        produitRepository.save(produit);
    }
}
