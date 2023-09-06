package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Cart;
import com.example.projet_pfa.entity.Produit;
import com.example.projet_pfa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findById(int id);
    Cart findByUser(User user);

    @Query("SELECT c FROM Cart c WHERE c.user.id = :userId AND c.produit.id = :produitId")
    Cart findByUserIdAndProduitId( int userId,  int produitId);
    List<Cart> findByUserId(int id);
}
