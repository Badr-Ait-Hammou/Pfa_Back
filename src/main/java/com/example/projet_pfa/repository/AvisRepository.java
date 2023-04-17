package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisRepository extends JpaRepository<Avis,Integer> {
    Avis findById(int id);
}
