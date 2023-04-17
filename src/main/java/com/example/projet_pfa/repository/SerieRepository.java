package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends JpaRepository<Serie,Integer> {

    Serie findById(int id);
}
