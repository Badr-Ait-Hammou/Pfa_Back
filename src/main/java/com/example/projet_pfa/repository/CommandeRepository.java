package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
    Commande findById(int id);
}
