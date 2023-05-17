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
    @Column(length =50000)
    private String photo;
    private int stock;
    private Boolean promotion;
    private double prix;
   // private double prixanc;

    @ManyToMany(mappedBy = "produitList")
    private List<Commande> commandeList;


    @ManyToMany(mappedBy = "produitList")
    @JsonIgnore
    private List<Panier> panierList ;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
