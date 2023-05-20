package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findById(int id);
}
