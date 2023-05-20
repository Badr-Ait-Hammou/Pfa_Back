package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Cart;
import com.example.projet_pfa.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements Dao<Cart> {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart save(Cart cart) throws Exception {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(int id) {
        return cartRepository.findById(id);
    }

    @Override
    public void delete(Cart o) {

    }
}
