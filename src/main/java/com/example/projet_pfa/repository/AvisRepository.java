package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface AvisRepository extends JpaRepository<Avis,Integer> {
    Avis findById(int id);
    List<Avis> findByUserId(int id);
}
