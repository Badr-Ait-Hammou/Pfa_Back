package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.CartItem;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    List<CartItem> findByCartId(int id);


    Optional<CartItem> findByCartIdAndProduitId(Integer idcart,Integer idproduit);
}
