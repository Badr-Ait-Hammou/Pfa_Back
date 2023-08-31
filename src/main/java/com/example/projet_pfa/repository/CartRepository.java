package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Cart;
import com.example.projet_pfa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findById(int id);
    Cart findByUser(User user);
    List<Cart> findByUserId(int id);
}
