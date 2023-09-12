package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String note;
    private int rating;
    @ManyToOne
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "avisList", "restaurant"})
    private Produit produit;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "avisList", "user","produit"})
    private Orders orders;

}
