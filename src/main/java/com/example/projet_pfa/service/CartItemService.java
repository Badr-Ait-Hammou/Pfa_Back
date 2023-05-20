package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.CartItem;
import com.example.projet_pfa.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService implements Dao<CartItem> {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem save(CartItem cartItem) throws Exception {
        Optional<CartItem> cartItem1 = cartItemRepository.findByCartIdAndProduitId(cartItem.getCart().getId(), cartItem.getProduit().getId());
        if (cartItem1.isPresent()) {
            throw new Exception("Item already exist ");
        } else {
            return cartItemRepository.save(cartItem);
        }
    }

    @Override
    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem findById(int id) {
        return null;
    }

    public Optional<CartItem> getById(int id) {
        return cartItemRepository.findById(id);
    }

    @Override
    public void delete(CartItem o) {

    }
}
