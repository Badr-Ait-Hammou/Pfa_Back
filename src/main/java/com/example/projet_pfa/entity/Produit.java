package com.example.projet_pfa.entity;

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
    private String photo;
    private int stock;
    private Boolean promotion;
    private double prix;

    @ManyToMany(mappedBy = "produitList")
    private List<Commande> commandeList;
}
