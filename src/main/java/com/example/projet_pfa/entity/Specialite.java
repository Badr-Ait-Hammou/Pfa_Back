package com.example.projet_pfa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
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
    private List<Restaurant> restaurantList;




}
