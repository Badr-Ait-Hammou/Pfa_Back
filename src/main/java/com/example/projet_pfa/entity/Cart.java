package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private double totalprice;

    @OneToMany(mappedBy = "cart",fetch = FetchType.EAGER)
    private List<CartItem> cartItems;
    @ManyToOne
    private User user;

    @ManyToOne
    private Produit produit;
}
