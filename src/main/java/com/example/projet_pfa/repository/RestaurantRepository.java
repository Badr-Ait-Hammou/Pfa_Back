package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
 public Restaurant findById(int id);
 @Query("SELECT r FROM Restaurant r JOIN r.zone z JOIN z.ville v WHERE v.nom =?1 AND z.nom =?2")
 List<Restaurant> findPharmaciyByVilleAndZone(String ville, String zone);

}
