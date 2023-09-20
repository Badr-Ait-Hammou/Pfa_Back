package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
    private List<Avis> avisList;


    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Cart> cartList ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "produitList"})
    private Restaurant restaurant;

}
