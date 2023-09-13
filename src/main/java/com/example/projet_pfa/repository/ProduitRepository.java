package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Integer> {
    Produit findById(int id);
    @Query("select p from Produit p where p.restaurant.id=:id order by p.id")
    List<Produit> findProduitsByRestaurant(@Param("id") Integer id);

    List<Produit> findProduitByRestaurantSpecialiteId(Integer id);

    List<Produit> findByPromotionEquals(boolean id);
    List<Produit> findByPromotionIsFalse();

}
