package com.example.projet_pfa.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Specialite {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;


    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="restaurant_specialite",
            joinColumns = { @JoinColumn(name="specialite_id") },
            inverseJoinColumns = { @JoinColumn(name="restaurant_id") })
    private Set<Restaurant> restaurant = new HashSet<Restaurant>();


    public Specialite() {
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
