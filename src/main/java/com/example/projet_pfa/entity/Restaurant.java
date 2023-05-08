package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFermeture;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOuverture;
    private int latitude;
    private int longitude;
    private String adresse;
   // private double rank;
    private String photo;

    @ManyToOne
    private Serie serie;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @ManyToMany(mappedBy = "restaurantList",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Specialite> specialiteList;


    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<Produit> produitList;







}
