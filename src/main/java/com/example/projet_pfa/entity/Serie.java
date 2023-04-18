package com.example.projet_pfa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "serie", fetch = FetchType.EAGER)
    private List<Restaurant> restaurantList;



}

