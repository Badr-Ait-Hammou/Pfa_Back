package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
    @Column(length =500000)
    private String photo;
    private int stock;
    private Boolean promotion;
    private double prix;
   // private double prixanc;


    @OneToMany(mappedBy = "produit")
    @JsonIgnore
    private List<CartItem> cartItems ;

    @OneToMany(mappedBy = "produit")
    @JsonIgnore
    private List<OrdersItem> orderItems ;

    @OneToMany(mappedBy = "produit")
    @JsonIgnore
    private List<Cart> cartList ;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    /*
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Orders> ordersList;
*/
}
