package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Cart;
import com.example.projet_pfa.entity.Produit;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.service.CartService;
import com.example.projet_pfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller/carts")
@CrossOrigin
public class CartController {



    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Cart save(@RequestBody Cart cart)  throws Exception{
        return cartService.save(cart);
    }
    @GetMapping("/incart/{userId}/{produitId}")
    public Cart findByUserIdAndProduitId(@PathVariable int userId,@PathVariable int produitId) {
        return cartService.findByUserIdAndProduitId(userId, produitId);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        cartService.deleteById(id);
    }


    @GetMapping("/userid/{id}")
    public List<Cart> findByUserId(@PathVariable int id) {
        return cartService.findByUserId(id);
    }


    @GetMapping("/")
    public List<Cart> findAll() {
        return cartService.findAll();
    }

    @GetMapping("/{id}")
    public Cart findById(@PathVariable int id) {
        return cartService.findById(id);
    }

    public void delete(Cart o) {
        cartService.delete(o);
    }


    @PostMapping("/{userId}/add-item")
    public Cart addItemToCart(@PathVariable int userId, @RequestBody Produit produit) {
        User user = userService.findById(userId);
        return cartService.addItemToCart(user, produit.getId(), produit.getStock());
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable int userId) {
        User user = userService.findById(userId);
        return cartService.getOrCreateCart(user);
    }

}
