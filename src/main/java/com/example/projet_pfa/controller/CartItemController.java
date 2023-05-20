package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.CartItem;
import com.example.projet_pfa.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller/cartitems")
@CrossOrigin
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/")
    public CartItem save(@RequestBody CartItem cartItem) throws Exception {
        return cartItemService.save(cartItem);
    }

    @GetMapping("/")
    public List<CartItem> findAll() {
        return cartItemService.findAll();
    }

    @GetMapping("/{id}")
    public CartItem findById(@PathVariable int id) {
        return cartItemService.findById(id);
    }

    public void delete(CartItem o) {
        cartItemService.delete(o);
    }



}
