package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Integer> {
    Produit findById(int id);
}
