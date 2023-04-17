package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville,Integer> {
    public Ville findById(int id);
}
