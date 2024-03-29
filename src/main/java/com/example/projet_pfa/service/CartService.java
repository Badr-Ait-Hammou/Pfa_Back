package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Cart;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements Dao<Cart> {


    public Cart findByUserIdAndProduitId(int userId, int produitId) {
        return cartRepository.findByUserIdAndProduitId(userId, produitId);
    }

    @Autowired
    private CartRepository cartRepository;



    public void deleteById(int id ) {
        cartRepository.deleteById(id);
    }

    @Autowired
    private ProduitService produitService;
    @Override
    public Cart save(Cart cart) throws Exception {
        return cartRepository.save(cart);
    }
    public List<Cart> findByUserId(int id) {
        return cartRepository.findByUserId(id);
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


    public Cart getOrCreateCart(User user) {
        Optional<Cart> optionalCart = Optional.ofNullable(cartRepository.findByUser(user));
        if (optionalCart.isPresent()) {
            return optionalCart.get();
        } else {
            Cart cart = new Cart();
            cart.setUser(user);
            return cartRepository.save(cart);
        }
    }



}
