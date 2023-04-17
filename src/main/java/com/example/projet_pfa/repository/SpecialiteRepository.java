package com.example.projet_pfa.repository;


import com.example.projet_pfa.entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialiteRepository extends JpaRepository<Specialite,Integer> {
    Specialite findById(int id);
}
