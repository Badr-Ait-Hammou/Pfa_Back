package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Panier;
import com.example.projet_pfa.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PanierRepository extends JpaRepository<Panier,Integer> {
    Panier findById(int id);

 //   @Query("select z from Zone z where z.ville.nom=:nom order by z.nom")
 @Query("SELECT p FROM Panier p JOIN p.produitList pp WHERE p.user.id = :id")
 List<Panier> findAllUserPanierProducts(@Param("id") int id);


}
