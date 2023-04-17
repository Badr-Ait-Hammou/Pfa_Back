package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
 public Restaurant findById(int id);
}
