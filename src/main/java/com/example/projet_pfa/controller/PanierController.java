package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Panier;
import com.example.projet_pfa.entity.Produit;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller/paniers")
@CrossOrigin
public class PanierController {


    @GetMapping("userproductsinbasket/{id}")
    public List<Panier> findAllUserPanierProducts(@PathVariable int id) {
        return panierService.findAllUserPanierProducts(id);
    }

    @Autowired
    private PanierService panierService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return panierService.getUserById(id);
    }

    @GetMapping("/produit/{id}")
    public Produit getProductById(@PathVariable Integer id) {
        return panierService.getProductById(id);
    }

    @PostMapping("/panier/user/{id}")
    public Panier createPanier(@PathVariable int id) {
        return panierService.createPanier(id);
    }

    @PostMapping("/{cartId}/{productId}")
    public void addProductToCart(@PathVariable Integer cartId, @PathVariable Integer productId) {
        panierService.addProductToCart(cartId, productId);
    }
    @DeleteMapping("/{cartId}/{productId}")
    public void removeProductFromCart(@PathVariable Integer cartId,@PathVariable Integer productId) {
        panierService.removeProductFromCart(cartId, productId);
    }
    @GetMapping("/productinbasket/{cartId}")
    public List<Produit> getProductsInCart(@PathVariable Integer cartId) {
        return panierService.getProductsInCart(cartId);
    }







}
