package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Cart;
import com.example.projet_pfa.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller/carts")
@CrossOrigin
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/")
    public Cart save(@RequestBody Cart cart)  throws Exception{
        return cartService.save(cart);
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


}
