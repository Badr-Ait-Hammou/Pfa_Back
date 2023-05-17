package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Panier;
import com.example.projet_pfa.entity.Produit;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.repository.PanierRepository;
import com.example.projet_pfa.repository.ProduitRepository;
import com.example.projet_pfa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierService implements Dao<Panier> {


    public List<Panier> findAllUserPanierProducts(int id ) {
        return panierRepository.findAllUserPanierProducts(id);
    }

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Panier save(Panier panier) {
       return panierRepository.save(panier);
    }

    @Override
    public List<Panier> findAll() {
        return panierRepository.findAll();
    }

    @Override
    public Panier findById(int id) {
        return panierRepository.findById(id);
    }

    @Override
    public void delete(Panier o) {

    }
    /*
    public void deletePanier(Integer id){
        Panier panier = panierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("panier not found with id " + id));
        panierRepository.delete(panier);
    }*/

    public User getUserById(Integer id ) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    public Produit getProductById(Integer id) {
        return produitRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    private Panier getCartById(Integer id) {
        return panierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shopping cart not found with id " + id));
    }

    public Panier createPanier(Integer id) {
        User user = getUserById(id);
        Panier panier = new Panier();
        panier.setUser(user);
        return panierRepository.save(panier);
    }

    public void addProductToCart(Integer cartId, Integer productId) {
        Panier panier = getCartById(cartId);
        Produit produit = getProductById(productId);
        panier.getProduitList().add(produit);
        panierRepository.save(panier);
    }

    public void removeProductFromCart(Integer cartId, Integer productId) {
        Panier panier = getCartById(cartId);
        Produit produit = getProductById(productId);
        panier.getProduitList().remove(produit);
        panierRepository.save(panier);
    }

    public List<Produit> getProductsInCart(Integer cartId) {
        Panier panier = getCartById(cartId);
        return panier.getProduitList();
    }


}
