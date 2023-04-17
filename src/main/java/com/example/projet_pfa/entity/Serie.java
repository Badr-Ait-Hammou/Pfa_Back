package com.example.projet_pfa.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "serie", fetch = FetchType.EAGER)
    private List<Restaurant> restaurant;


    public Serie() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

